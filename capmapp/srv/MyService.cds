//Creating Custom Service Definition or Custom End Point other than our DB Tables
//Its like a MPC Class

service MyService @(path: 'MyService'){

//Creating function definition with importing parameter name. 
//It is like a entityset: display
function display(name : String(20)) returns String;

}