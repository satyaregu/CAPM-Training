
//Callback function example - Asynchronous execution
const joule = () => {
    console.log("Getting readyfor office, cab has come");

    //John
    setTimeout(

        //when john comes back - call the callback - Ben uncle
        function () {
            console.log("John collects the key from Ben uncle"); 
        }, 5000);

    console.log("Joule left for office");
}

joule();

//Promise function example - Synchronous execution
//Step-1: Promisify async function
const satyaPromise = milliSecond => new Promise( resolve => setTimeout(resolve, milliSecond) );

//Step-2: Implement the promise function - handler
const checkPromise = () => {
    return satyaPromise(5000).then(() => {
        console.log("The timer of 5 seconds is now finished");
    });
}

//Step-3: call the function Synchronously - async, await 
//Forcing Java Script to run sync mode, only possible when we promisify
const finalTest = async() => {
    console.log("Before calling my promise");

    await checkPromise();

    console.log("After calling my promise");
}

finalTest();

