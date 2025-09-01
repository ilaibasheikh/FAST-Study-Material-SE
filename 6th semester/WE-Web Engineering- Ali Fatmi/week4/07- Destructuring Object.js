let user = {
	name : "Yahoo Baba",
	age : 25,
	city : "Delhi"
}

let {name, age, city} = user;

console.log(city);

//Using Alias Name
let user = {
	name : "Yahoo Baba",
	age : 25,
	city : "Delhi"
}

let {name : n,age : a,city : c} = user;

console.log(n);