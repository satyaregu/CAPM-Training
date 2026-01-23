//Creating name space
namespace satya.db;

//Importing the Standard Aspects
using {
    cuid,
    managed,
    temporal,
    Currency
} from '@sap/cds/common';

//Importing the Custom Aspects
using {satyadb.commons as common} from './commons';

//Creating Context for Master Data Tables
context master {
    //Business Partner Table with Association to Address Table
    entity businesspartner {
        key NODE_KEY      : common.Guid; //using custom type
            BP_ROLE       : String(2);
            EMAIL_ADDRESS : String(105);
            PHONE_NUMBER  : String(32);
            FAX_NUMBER    : String(32);
            WEB_ADDRESS   : String(44);
            //This field name will become ADDRESS_GUID_NODE_KEY as it is associated with address table
            ADDRESS_GUID  : Association to one address; //Inserting Assocation with address Table.
            BP_ID         : String(22);
            COMPANY_NAME  : String(250);
    }

    //Address Table with Association to Business Partner Table
    entity address {
        key NODE_KEY        : common.Guid;
            CITY            : String(44);
            POSTAL_CODE     : String(8);
            STREET          : String(44);
            BUILDING        : String(128);
            COUNTRY         : String(44);
            ADDRESS_TYPE    : String(44);
            VAL_START_DATE  : Date;
            VAL_END_DATE    : Date;
            LATITUDE        : Decimal;
            LONGITUDE       : Decimal;
            //Inserting Association with business partner table with self key. i.e. NODE_KEY of address table
            businesspartner : Association to one businesspartner
                                  on businesspartner.ADDRESS_GUID = $self;
    }

    //Product Table
    entity product {
        key NODE_KEY       : common.Guid; //Using the Custom Type
            PRODUCT_ID     : String(28);
            TYPE_CODE      : String(2);
            CATEGORY       : String(32);

            //Creating Text Table for Description Column to maintain language specific text. 
            //It will create product_texts table automatically
            DESCRIPTION    : localized String(255);

            //This field name will become SUPPLIER_GUID_NODE_KEY as it is associated with businesspartner table
            SUPPLIER_GUID  : Association to businesspartner; //Inserting Association to Business Partner Table
            TAX_TARIF_CODE : Integer;
            MEASURE_UNIT   : String(2);
            WEIGHT_UNIT    : String(2);
            WEIGHT_MEASURE : Decimal(5, 2);
            CURRENCY_CODE  : String(4);
            PRICE          : Decimal(15, 2);
            WIDTH          : Decimal(5, 2);
            HEIGHT         : Decimal(5, 2);
            DEPTH          : Decimal(5, 2);
            DIM_UNIT       : String(2);
    }

    //Employe Table with Auto Key
    entity employees : cuid { //Using standard aspect cuid. This will genarate the key value automatically
        //This table will have ID field as we are imporing cuid aspect
        nameFirst     : String(40);
        nameMiddle    : String(40);
        nameLast      : String(40);
        nameInitials  : String(40);
        sex           : common.Gender; //Using the Custom Type
        language      : String(1);
        phoneNumber   : common.PhoneNumber; //Using the Custom Type
        email         : common.EmailAddress; //Using the Custom Type
        currency      : Currency;
        salaryAmount  : common.amountT; //Using the Custom Type
        accountNumber : String(16);
        bankId        : String(8);
        bankName      : String(64);
    }

}

//Creating Context for Transaction Data Tables
context transaction {
    //Purchase Order Table with Custom Aspect
    entity purchaseorder : common.amount { //using Custom Aspect amount
            //This table will have all fields from amount aspect
        key NODE_KEY         : common.Guid; //Using Custom Type
            PO_ID            : String(40);
            PARTNER_GUID     : Association to one master.businesspartner; //Inserting Association to Business Partner Table
            LIFECYCLE_STATUS : String(1);
            //Inserting Association with poitems table with self key. i.e. NODE_KEY of purchaseorder table
            Items            : Association to many poitems
                                   on Items.PARENT_KEY = $self;
    }

    //Purchase Order Item Table with Custom Aspect
    entity poitems : common.amount {
            //This table will have all fields from amount aspect
        key NODE_KEY     : common.Guid; //Using Custom Type

            //This field name will become PARENT_KEY_NODE_KEY as it is associated with purchaseorder table
            PARENT_KEY   : Association to purchaseorder; //Inserting Association to purchaseorder table
            PO_ITEM_POS  : Integer;

            //This field name will become PRODUCT_GUID_NODE_KEY as it is associated with product table
            PRODUCT_GUID : Association to master.product; //Inserting Association to product table
    }

}
