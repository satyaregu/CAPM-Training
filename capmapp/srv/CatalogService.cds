//Importing the Master & Transaction tables from data-model.cds file
//If you not mention alias name then system will automatically take last word as alias name
using { satya.db.master, satya.db.transaction } from '../db/data-model';

//Creating the Service
service CatalogService @(path: 'CatalogService') {

//Creating the Entity Set for each table
entity BusinessPartnerSet as projection on master.businesspartner;
entity AddressSet as projection on master.address;
entity EmployeeSet as projection on master.employees;
entity ProductSet as projection on master.product;

entity POs as projection on transaction.purchaseorder
//Defining the Bound Action - Entity Set specific action - to modify the amount
actions {
    //Defining boost action for POs entity set
    action boost() returns POs;
};

entity POItems as projection on transaction.poitems;
    
}