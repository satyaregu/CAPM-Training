const cds = require('@sap/cds');
//const { elements } = require('@sap/cds/lib/ql/cds.ql-infer');

//Defining the implementation for services
module.exports = cds.service.impl(async function (srv) {

    const { MySalesOrder } = this.entities;

    //Creating a function to Get all the Sales Orders from the Standard Sales Order API
    const getAllSalesOrder = async function () {
        //get the main class object which has APIs for all entities
        const { opApiSalesOrderSrv0001 } = require('./src/generated/OP_API_SALES_ORDER_SRV_0001');

        //get the sales order header API object to communicate to SAP
        const { salesOrderApi } = opApiSalesOrderSrv0001();

        //Make a call to SAP system to get the top 10 records
        const dataSalesOrders = await salesOrderApi.requestBuilder().getAll().top(10)
            .select(
                salesOrderApi.schema.SALES_ORDER,
                salesOrderApi.schema.SALES_ORGANIZATION,
                salesOrderApi.schema.SALES_ORDER_TYPE,
                salesOrderApi.schema.SOLD_TO_PARTY,
                salesOrderApi.schema.PAYMENT_METHOD,
                salesOrderApi.schema.TO_ITEM
            ).execute({
                //SAP system ip and host name. For local testing we are hardcoding the system details
               // url: 'http://122.162.240.164:8021',  
               // username: 'mob5',         //SAP user id
               // password: '**********'    //SAP password

               //Adding SAP System Destination to remove the hard codes
               destinationName: 'S4HANA2022'
               
            });

        //returning the SAP sales order data
        return dataSalesOrders;
    }

    //Implementing Genaric Hanlder "ON" for READ method for entity set MySalesOrder    
    srv.on('READ', MySalesOrder, async (req) => {

        //Creating a sales order table with sample data
        var salesOrderTab = [
            { SalesOrder: 100, SalesOrganization: '1010', SoldToParty: "satya" },
            { SalesOrder: 101, SalesOrganization: '3000', SoldToParty: "jyothi" }
        ];

        //Returning the sample data on READ for MySalesOrder Entityset
        // return salesOrderTab;

        //calling the function to get the standard API data from S4 system
        var salesOrderTabAPI = await getAllSalesOrder().then(
            //once promise is fullfilled we receive our sales data from S4 system
            dataSalesOrders => {
                var aRecord = [];

                //loop over multiple records which came from SAP system
                dataSalesOrders.forEach(element => {

                    //here we can manipulate the data which is coming from SAP system
                    var record = {};
                    record.SalesOrder = element.salesOrder;
                    record.SalesOrganization = element.salesOrganization;
                    record.SalesOrderType = element.salesOrderType;
                    record.SoldToParty = element.soldToParty;
                    record.PaymentMethod = element.paymentMethod;

                    if (element.toItem[0]) {
                        record.Material = element.toItem[0].material;
                        record.RequestedQuantity = element.toItem[0].requestedQuantity;
                        record.NetAmount = element.toItem[0].netAmount;
                        record.SatyaAmount = record.RequestedQuantity * record.NetAmount;
                    } else {
                        record.Material = '';
                        record.RequestedQuantity = 0;
                        record.NetAmount = 0;
                    }

                    //append record to our local array
                    aRecord.push(record);
                });

                //returning the sales order data
                return aRecord;
            }
        )

        //returning the sales order data
        return salesOrderTabAPI;
    });

});