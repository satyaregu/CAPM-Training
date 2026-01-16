//reusing the standard module
//Step-1: standard event module provided by node
const events = require('events');

//Step-2: To use the event module, create an object of the class
var satya = new events.EventEmitter();

//Step-3: register an event to my object
satya.on("speak", () => {
    //event handler
    console.log("Satya is speaking");
});

satya.on("teach", function () {
    //event handler
    console.log("Satya is teaching");
});

satya.on("dance", () => {
    console.log("Satya is dancing");
});

//Step-4: Raise the event
satya.emit('speak');
satya.emit('teach');
satya.emit('dance');


