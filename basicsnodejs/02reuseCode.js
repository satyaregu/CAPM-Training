//To use a JS Module, we use require keyword like INCLUDE in the ABAP

const reuse = require('./util/reuse');

//We can use the object to call the functions from module
reuse.addNumber(20, 50);

reuse.getSizeArray([1, 2, 3, 67, 87, 90]);

reuse.printJSON({"team" : "India",
                 "captain" : "Rohit"
});

