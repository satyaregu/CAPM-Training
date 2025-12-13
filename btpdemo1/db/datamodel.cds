namespace  satya;

entity supermarket_orders
{
key Invoice : UUID

@Core.Computed;
@title : 'Branch'
Branch : String(100);

@title : 'City'
City : String(100);

@title : 'Customer Type'
CustomerType : String(100);

@title : 'Product Type'
ProductType : String(100);

@title : 'Price'
Price : Decimal(5, 2);

@title : 'Quantity'
Quantity : Integer;

@title : 'Total'
Total : Decimal(10, 2);

@title : 'Payment'
Payment : String(100);

}
