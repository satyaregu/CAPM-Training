//Creating Custom Service Definition or Custom End Point other than our DB Tables
//Its like a MPC Class

//Importing the CDS Views from CDSViews.cds file
//If you not define the alias name while importing then system will take last word as alias. i.e. cds
using {satya.cds} from '../db/CDSViews';


service MyService @(path: 'MyService') {

    //Creating function definition with importing parameter name.
    //It is like a entityset: display
    function display(name: String(20)) returns String;

    //Creating a Entity Set for CDS View Association with navigation property
    entity ProductOrderSet as
        projection on cds.CDSViews.ProductOrders {
            *,
            ProductOrders
        };
}
