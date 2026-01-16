//Print message on the console - WRITE statement in ABAP
console.log("Welcome to CAPM Training");

//Creating Variables in Java Script
var x = 10;   //Global Variable - It is a Scalar Variable which holds single value
var y = 20;   //Global Variable - It is a Scalar Variable which holds single value

let z = x + y ;  //Local Variable - It is a Scalar Variable which holds single value

this.tax = 100;  //Global Variable with Null Value

let a = x + y + this.tax ; //Value of the Null Variable is NaN

console.log("The Total Values Z is: " + z );

console.log("The Total of A is: " + a );

//String Operations
var firstName = "Satya";  //Use Camel Case for declaring the variables
var lastName = 'Regu';
var mr = "MR";

let empName = mr + " " + firstName + ' ' + lastName ; 

console.log(empName);

//If Conditions
// = -- It assign the values
// == -- It compare the values
// === -- It compare the values and data types

if (firstName === lastName) {
    console.log('The Values are same');
} else {
    console.log("The values are different");
}

//Arrays in Java Script - It holds multiple values of same data type
var arrFruits = ["Apple", 'Banana', "Cherry"];

//Adding an item to array list at the end
arrFruits.push("pineapple");
console.log(arrFruits);

//Removing an item from array list from the end
arrFruits.pop();
console.log(arrFruits);

//Adding an item(s) to array list at the begining
arrFruits.splice(0, 0, "Orange", "Mango");
console.log(arrFruits);

//Removing an item(s) from array list from the begining
arrFruits.splice(0, 2);
console.log(arrFruits);

//Adding an item to array list at the middle
arrFruits.splice(2, 0, "Grapes");
console.log(arrFruits);

//Removing an item from array list from the middle
arrFruits.splice(2, 1);
console.log(arrFruits);

//Splitting the string separated by space and save into a Array
var arrText = empName.split(" ");
console.log(arrText);

//Loop an array
//Syntax-1
for (let i = 0; i < arrFruits.length; i++)
{
    const fruitName = arrFruits[i];
    console.log(fruitName);
}

//Syntax-2
arrFruits.forEach(fruit => {
    console.log(fruit);
});

//Functions in Java Script
var myFunction = function (a, b){  //Its a Named Function - Means a function having a name
    return a + b;
}
console.log(myFunction(10, 20));

//Arrow Function - Its a new function syntax in Java Script
//Here the access to global variables is permitted
var myArrowFunction = (a, b) =>{
    return a + b + this.tax;
}
console.log(myArrowFunction(40, 80));

//Objects in Java Script - It is also called JSON - Java Script Object Notation
var oEmp = {
    "empNo" : 1010,
    "empName" : "Satya",
    "salary" : 50000,
    "currency" : "INR"
};

//Print or Change one JSON variable value
oEmp.empNo = 2020;
console.log(oEmp);

//Convert JSON to a String
var myStr = JSON.stringify(oEmp);
console.log(myStr);

//Convert String to JSON
var myJSON = JSON.parse(myStr);
console.log(myJSON);

//Loop over JSON properties - Loop In syntax
for (const key in oEmp) {
    if (!Object.hasOwn(oEmp, key)) continue;
    
    const element = oEmp[key];
    console.log("The value of " + key + " is: " + element);
    
}








