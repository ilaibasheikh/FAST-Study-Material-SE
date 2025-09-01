class hello{

 message(){
   console.log("Hello Everyone");
 }                                                                                             
}

let a = new hello();

console.log(typeof a);

a.message();

//Constructor function in class
class student{
  constructor(){
     console.log("Constructor Function")
  }	
}
	
let a = new student();

//Initilize Property
class student{
  constructor(){
    let studentname;
  }	
}

let a = new student();

a.studentname = "Yahoo Baba";

//Initilize Property with constructor
class student{
  constructor(name){
    console.log("Hello " + name);
  }	
}

let a = new student("Yahoo Baba");

//Prototype method
class student{
  constructor(name){
    this.studentname = name;
  }
  hello(){
    console.log("Hello " + this.studentname);
  }	
}

let a = new student('Yahoo Baba');
a.hello();

//Static Method
class student{
  static staticMethod(){
    console.log("Static Method");
  }
}

student.staticMethod();
