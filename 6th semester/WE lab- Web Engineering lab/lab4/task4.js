const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl.question('enter first num: ', (num1) => {
    rl.question('enter second numb: ', (num2) => {
        num1 = parseFloat(num1);
        num2 = parseFloat(num2);


        const add = num1 + num2;
        const subtract = num1 - num2;
        const multiply = num1 * num2;
        const divide = num1 / num2;


        console.log(`Addition: ${add}`);
        console.log(`Subtraction: ${subtract}`);
        console.log(`Multiplication: ${multiply}`);
        console.log(`Division: ${divide}`);
        rl.close();
    });
});
