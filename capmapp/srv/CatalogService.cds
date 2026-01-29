//Importing the Master & Transaction tables from data-model.cds file
//If you not mention alias name then system will automatically take last word as alias name
using {
    satya.db.master,
    satya.db.transaction
} from '../db/data-model';

//Creating the Service
service CatalogService @(
    path    : 'CatalogService',
    requires: 'authenticated-user' //adding security to this service
) {

    //Creating the Entity Set for each table
    entity BusinessPartnerSet as projection on master.businesspartner;
    entity AddressSet         as projection on master.address;

    entity EmployeeSet @(restrict: [
        //Adding Read Access to only who has access to Viewer Role
        {
            grant: 'READ',
            to   : 'Viewer',
            where: 'bankName = $user.BankName' //Adding Row Level security based on the bankName field
        },

        //Adding Write Access to only who has access to Admin Role
        {
            grant: 'WRITE',
            to   : 'Admin'
        }
    ])                        as projection on master.employees;

    entity ProductSet         as projection on master.product;

    //Defining the Unbound Function to get the default value for the Life Cycle Status Field
    function DefaultLifeCycleStatus() returns POs;

    entity POs @(
        //enabling draft functionality
        odata.draft.enabled         : true,

        //Enabling Default Value with DefaultLifeCycleStatus unbound function
        Common.DefaultValuesFunction: 'DefaultLifeCycleStatus'

    )                         as
        projection on transaction.purchaseorder {
            *,
            //Adding the text
            case
                LIFECYCLE_STATUS
                when 'N'
                     then 'New'
                when 'R'
                     then 'Rejected'
                when 'A'
                     then 'Approved'
            end as LifeCycleStatus : String(20),
            Items
        }

        //Defining the Bound Action - Entity Set specific action - to modify the amount
        actions {
            @cds.odata.bindingparameter.name: '_satya'
            @Common.SideEffects             : {TargetProperties: ['_satya/GROSS_AMOUNT']}

            //Defining boost action for POs entity set
            action boost() returns POs;
        };

    entity POItems            as projection on transaction.poitems;

}
