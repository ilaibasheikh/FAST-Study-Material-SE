//hoisting concept
console.log(a);
// ✅ Output: undefined
var a = 10; //declaration hoisted but not the value, so this will not be an error
//console.log(b);
// ✅ Output: error: b is not defined
//error: because there is no declaration


//Let Const and Var

//var is function-scoped → accessible anywhere inside a function.
//let and const are block-scoped → only accessible inside {}.
function checkScope() {
    if (true) {
        var a = "I am var";  // Function-scoped
        let b = "I am let";  // Block-scoped
        const c = "I am const";  // Block-scoped
    }

    console.log(a); // ✅ Accessible (function-scoped)
    console.log(b); // ❌ ReferenceError: b is not defined (block-scoped)
    console.log(c); // ❌ ReferenceError: c is not defined (block-scoped)
}
// checkScope();

//if else 
let day = 2;

if (day === 1) {
    console.log("Monday");
} else if (day === 2) {
    console.log("Tuesday");
    // This will run because 'day' is 2.
} else {
    console.log("Unknown day");
    // This block runs if no condition matches.
}
// switch cases
let days = 2;

switch (days) {
    case 1:
        console.log("Monday");
        break;
    case 2:
        console.log("Tuesday");

        break;
    default:
        console.log("Unknown day");

}

// Functions and its types:

//Named Functions : they are hoisted and can be called before declaration
function greet(name) {
    return "Hello, " + name;
}
console.log(greet("John")); // Hello, John

//Anonymous Function: not hoisted
const greetAnon = function (name) {
    return "Hello, " + name;
};
console.log(greetAnon("John")); //  Hello, John

//Arrow Functions: not hoisted
const greetArrow = (name) => "Hello, " + name;
console.log(greetArrow("John")); // Output: Hello, John


//Arrays
let arr = [1, 2, 3, 4]
arr.push(12);
console.log("Array ", arr)
//inserts element at the start
arr.unshift(5)
console.log("Array ", arr)
//removing the last element 
arr.pop()
console.log("Array ", arr)

//Array2
let fruits = ["apple", "banana", "cherry"];

// Adds "orange" to the end of the array.
fruits.push("orange");
console.log(fruits); // ["apple", "banana", "cherry", "orange"]

// Removes the last element ("orange") from the array.
fruits.pop();
console.log(fruits); // ["apple", "banana", "cherry"]

// Removes the first element ("apple") from the array.
fruits.shift();
console.log(fruits); // ["banana", "cherry"]

// Adds "kiwi" to the beginning of the array.
fruits.unshift("kiwi");
console.log(fruits); // ["kiwi", "banana", "cherry"]

// Creates a new array where each fruit is transformed to uppercase.
//map creates a new array
//uppercaseFruits is a new array where fruit is an iterator

let uppercaseFruits = fruits.map(fruit => fruit.toUpperCase());
console.log(uppercaseFruits); // ["KIWI", "BANANA", "CHERRY"]


//objects:
let person = {
    name: "John",
    age: 30,
    city: "New York"
};
// for in loop
for (let key in person) {
    console.log(key + ":", person[key]);
}

//for loop
for (let fruit of fruits) {
    console.log(fruit);
}

