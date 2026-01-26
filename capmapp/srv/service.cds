//Reusing the entity or tables which are created in the demo.cds file
using {
    satyadb.master as master,
    satyadb.trans  as transaction
} from '../db/demo';

//Creating the service
service BookService {

    //Creating entity set
    //Enabling draft functionality
    entity StudentSet @(odata.draft.enabled: true)  as projection on master.student

        actions {
            //Creating the Bound Action - to update
            action   CustomAction()   returns StudentSet;

            //Creating the bound Function - to read
            function CustomFunction() returns StandardsSet;
        };

    //By defaul CAP will enable all CRUD operations on all entity sets
    //If you want to only enable READ operation then set below annotation
    @readonly
    entity StandardsSet as projection on master.standards;

    //Set only Insert operation for this entity set
    @Capabilities: {Insertable}
    entity BooksSet     as projection on master.books;

    //Set only Insert and Delete operations for this entity set
    @Capabilities: {
        Insertable,
        Deletable
    }
    entity RentalsSet   as projection on transaction.rentals;
}
