//let's create a promise that divides two numbers
let promise = new Promise(function(resolve, reject) {
    //inside of the executor stored in the promise
    let num = prompt("Enter a numerator");
    let den = prompt("Enter a denominator");

    //convert to numbers
    num = parseFloat(num);
    den = parseFloat(den);

    //check for bad inputs (NaN)
    if (Number.isNaN(num) || Number.isNaN(den))
    {
        throw Error("User entered non-numerical values");
    }

    if (den === 0)
    {
        reject("Cannot divide by zero");
    }
    else
    {
        let result = num / den;
        resolve("Result is " + result);
    }
});

promise
    .then(function(success) {
        console.log("The promise was successful!");
        console.log(success);
    }, function(failure) {
        console.log("The promise was unsuccessful!");
        console.log(failure);
    })
    .catch(function(error) {
        console.log("Something went wrong");
        console.log(error);
    });
