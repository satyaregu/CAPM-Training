namespace satyadb.commons;

//Importing standard aspect
using {Currency} from '@sap/cds/common';

//Custom Type with domain fixed values
type Gender       : String(1) enum {
    male = 'M';
    female = 'F';
    undisclosed = 'U';
}

//Custom Type with Currency Key
type amountT      : Decimal(10, 2) @(
    Semantic.amount.currencyCode: 'CURRENCY_code',
    sap.unit                    : 'CURRENCY_code'
);

//Custom Type with Field Validation
type PhoneNumber  : String(30) @assert.format: '^(\+?\d{1,3}[\s-]?)?\(?\d{3}\)?[\s-]?\d{3}[\s-]?\d{4}$';

type EmailAddress : String(80) @assert.format: '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$';

//Custom Type or Data Element
type Guid         : String(32);

//Custom Aspect to hold Amount with field descripton
aspect amount {
    CURRENCY     : Currency;
    GROSS_AMOUNT : amountT @(title: 'Gross Amount');
    NET_AMOUNT   : amountT @(title: 'Net Amount');
    TAX_AMOUNT   : amountT @(title: 'Tax Amount');
}

//Custom Aspect or Structure to hold address data
aspect address {
    HOUSENO : Int16;
    STREET  : String(32);
    CITY    : String(80);
    COUNTRY : String(3);
}
