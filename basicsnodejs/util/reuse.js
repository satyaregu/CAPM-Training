
//Create Custom Module OR Class OR Library
module.exports = {
    addNumber : function(a, b){
        console.log(a + b);
    },

    getSizeArray : function(arr){
        console.log("Size of the Array is: " + arr.length);
    },

    printArray : function(arr){
        for (let index = 0; index < arr.length; index++) {
            const element = arr[index];
            console.log(element);
        }
    },

    printJSON : function(obj){
        for (const key in obj) {
            if (!Object.hasOwn(obj, key)) continue;
            
            const element = obj[key];
            console.log(element);
            
        }
    }
}