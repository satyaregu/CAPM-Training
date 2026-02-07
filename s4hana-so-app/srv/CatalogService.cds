namespace s4hanasoapp.srv;

//Importing the standard odata api
using {OP_API_SALES_ORDER_SRV_0001 as external} from './external/OP_API_SALES_ORDER_SRV_0001';

//Creating a custom service
service CatalogService @(path: 'CatalogService') {

    //Creating a custom entity set using a standard entity set
    // entity MySalesOrder as projection on external.A_SalesOrder;

    entity MySalesOrder {
        SalesOrder        : String(10);
        SalesOrganization : String(10);
        SalesOrderType    : String(10);
        SoldToParty       : String(10);
        Material          : String(10);
        RequestedQuantity : Integer;
        NetAmount         : Integer;
        SatyaAmount       : Decimal(5, 2);
    }

}
