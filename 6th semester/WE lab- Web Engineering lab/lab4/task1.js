function dataTypes() {
    const str = "K225195";
    const person = { name: "Laiba", age: 21 };
    let numbers = [1, 2, 3, 4];
    let number = 10;
    var isActive = true;
    let undefinedVar;
    const emptyValue = null;
    const uniqueSymbol = Symbol("id");
    let bigNumber = 1234567890123456789012345678901234567890n;


    console.log("Object:", person);
    console.log("String:", str);
    console.log("Array:", numbers);
    console.log("Number:", number);
    console.log("Boolean:", isActive);
    console.log("Undefined:", undefinedVar);
    console.log("Null:", emptyValue);
    console.log("Symbol:", uniqueSymbol);
    console.log("BigInt:", bigNumber);
}


dataTypes();
