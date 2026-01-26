//Creating CDS Views for our application
namespace satya.cds;

//importing master tables and transaction tables from data-model.cds file
using {
    satya.db.master,
    satya.db.transaction
} from './data-model';

//Creating the CDS Views using tables
context CDSViews {

    //CDS View for PO Worklist
    define view ![POWorklist] as
        select from transaction.purchaseorder {
            key PO_ID                             as ![PurchaseOrderNo],
            key Items.PO_ITEM_POS                 as ![Position],
                PARTNER_GUID.BP_ID                as ![VendorId],
                PARTNER_GUID.COMPANY_NAME         as ![CompanyName],
                Items.GROSS_AMOUNT                as ![GrossAmount],
                Items.NET_AMOUNT                  as ![NetAmount],
                Items.TAX_AMOUNT                  as ![TaxAmount],
                case
                    LIFECYCLE_STATUS
                    when 'N'
                         then 'New'
                    when 'D'
                         then 'Delivered'
                    when 'P'
                         then 'Pending'
                    when 'A'
                         then 'Approved'
                    when 'R'
                         then 'Rejected'
                end                               as ![Status],
                Items.PRODUCT_GUID.DESCRIPTION    as ![Product],
                PARTNER_GUID.ADDRESS_GUID.COUNTRY as ![Country]
        };

    //CDS View for Product Search Help
    define view ![ProductVH] as
        select from master.product {
            //Adding labels to column
            @EndUserText.label: [
                {
                    language: 'EN',
                    text    : 'Product ID'
                },
                {
                    language: 'DE',
                    text    : 'Prodekt ID'
                }
            ]
            PRODUCT_ID  as ![ProductId],

            //Adding labels to column
            @EndUserText.label: [
                {
                    language: 'EN',
                    text    : 'Product Name'
                },
                {
                    language: 'DE',
                    text    : 'Prodekt Name'
                }
            ]
            DESCRIPTION as ![ProductName]
        };

    //CDS View for PO Items
    define view ![ItemView] as
        select from transaction.poitems {
                //  PARENT_KEY.NODE_KEY         as ![VendorId],
            key PRODUCT_GUID.NODE_KEY       as ![ProductId],
                CURRENCY                    as ![Currency],
                GROSS_AMOUNT                as ![GrossAmount],
                NET_AMOUNT                  as ![NetAmount],
                TAX_AMOUNT                  as ![TaxAmount],
                PARENT_KEY.LIFECYCLE_STATUS as ![Status]
        };

    //CDS View for Products with mixin - lazy loading
    define view ProductOrders as
        select from master.product
        //mixin is a keyword provided by CAPM to perform lazy loading
        //It is same like association in ABAP CDS View - lazy loading of dependent data

        mixin {
            PO_ORDERS : Association[1.. * ] to ItemView //Association Name: PO_ORDERS with ItemView
                            on PO_ORDERS.ProductId = $projection.ProductKey
        }
        into {
            NODE_KEY                           as ![ProductKey],
            DESCRIPTION                        as ![ProductName],
            PRICE                              as ![Price],
            SUPPLIER_GUID.BP_ID                as ![SupplierId],
            SUPPLIER_GUID.COMPANY_NAME         as ![SupplierName],
            SUPPLIER_GUID.ADDRESS_GUID.COUNTRY as ![Country],

            //Exposed association like ABAP which will lazy load orders of a given product at runtime on demand
            PO_ORDERS                          as ![ProductOrders] //Alias name for the association PO_ORDERS
        };

    //CDS View with another CDS View - like a consumption view with aggregations round, sum, decimal
    define view ![CProductAnalytics] as
        select from ProductOrders {
            ProductName,
            Country,
            round(
                sum(ProductOrders.ProductOrders.GrossAmount), 2
            ) as ![TotalPurchaseAmount] : Decimal(10, 2),
            ProductOrders.ProductOrders.Currency
        }
        group by
            ProductName,
            Country,
            ProductOrders.ProductOrders.Currency;

}
