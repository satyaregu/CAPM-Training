//define the name space to maintain the unique name for our project artefacts
namespace satyadb;

//Reusing the Types and Aspects which are declared in the commons.cds file
using {satyadb.commons as satyaCommons} from './commons';

//Reusing the Types and Aspects from standard file
using {
    cuid,
    temporal,
    managed
} from '@sap/cds/common';

//define the context to specify the type of data that the table is going to hold like master data, transactional data
context master {

    //entity or table to store the data
    //first table for storing student master data
    entity student : satyaCommons.address { //Adding Aspect into the entity
        key ID     : satyaCommons.Guid; //String(32);
            NAME   : String(80);
            CLASS  : Association to one standards; //Creating association with standards table for CLASS field
            GENDER : String(1);
    // CITY   : String(10);
    }

    //second table for storing the books in the library
    entity books {
        key ID       : satyaCommons.Guid; //String(32);
            BOOKNAME : String(30);
            AUTHOR   : String(80);
    }

    //Third table for storing class information
    entity standards {
        key ID           : Int16;
            CLASSNAME    : String(10);
            SECTIONS     : Int16;
            CLASSTEACHER : String(80);
    }
}

//context for Transactional tables
context trans {
    entity rentals : cuid, temporal, managed {
        STUDENT : Association to one master.student;
        BOOK    : Association to one master.books;
    }
}
