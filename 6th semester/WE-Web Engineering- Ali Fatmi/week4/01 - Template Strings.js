let user = "Yahoo Baba";
let marks = 350;
document.write("Hello " + user + " your marks is"+marks);


let user = "Yahoo Baba";
let marks = 350;
document.write(`Hello  ${user}  your marks is ${marks}`);


let firstName = "Yahoo";
let lastName = "Baba";

function fullname(firstName, lastName){
   return `${firstName} ${lastName}`;
}

let hello = `Hello  ${fullname(firstName, lastName)}  Welcome to 2021.`;

document.write(hello);