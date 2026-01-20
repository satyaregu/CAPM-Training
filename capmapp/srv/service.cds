//Reusing the entity or tables which are created in the demo.cds file
using {
    satyadb.master as master,
    satyadb.trans  as transaction
} from '../db/demo';

//Creating the service
service MyService {

    //Creating entity set
    entity StudentSet   as projection on master.student;
    entity StandardsSet as projection on master.standards;
    entity BooksSet     as projection on master.books;
    entity RentalsSet   as projection on transaction.rentals;
}
