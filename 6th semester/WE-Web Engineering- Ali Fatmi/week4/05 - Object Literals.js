//Before

let name = "Yahoo Baba",
	course = "Btech";

var obj = {
	name : name,
	course : course
};

console.log(obj);
console.log(obj.name);


//With Object Literals


let name = "Yahoo Baba",
	course = "Btech";

var obj = {
   name,
   course 
};

console.log(obj);
console.log(obj.name);


///Variable as a property name



et n = "name";

var obj = {
   [n] : "Yahoo Baba",
   course : "Btech", 
   detail(){
	return `${this.name} is student of ${this.course}`;
   }
};


//Computed property name  

let name = 'student';

var obj = {
   [name + "name"] : "Yahoo Baba",
   course : "Btech", 
   detail(){
	return `${this.studentname} is student of ${this.course}`;
   }
};


//Declare function in object before Object Literals 

var obj = {
	 name,
	 course, 
	 detail : function(){
	    return `${this.name} is student of ${this.course}`;
	 }
};

console.log(obj.detail());


//Declare function in object with Object Literals 

ar obj = {
	 name,
	 course, 
	 detail(){
       return `${this.name} is student of ${this.course}`;
     }
};

console.log(obj.detail());

// New Way to view object's property value
console.log(obj['name']);
console.log(obj['detail']());


//Return Function value as a Object Literal 


function student(fname, lname, course){
	let fullname = fname + " " + lname;

	return {fullname, course};
}

console.log(student(fname, lname, course));


//Let take variable as Object 


function student(fname, lname, course){
	let fullname = fname + " " + lname;

	return {fullname, course};
}

let s = student("Ram","Kumar", "Bcom");

console.log(s.fullname);
console.log(s.course);