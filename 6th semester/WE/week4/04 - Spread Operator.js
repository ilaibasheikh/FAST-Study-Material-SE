function sum(name,...args){
	console.log(arguments);

	document.write(`Hello ${name} : `);

	let sum = 0;
	for(let i in args){
		sum += args[i];
	}

	document.write(sum);
}

var arr = [20,30,40];
sum("Yahoo Baba",...arr);



var obj1 = {
	name : "Yahoo Baba",
	course : "Btech"
}

var obj2 = {
	age : 25
}

var obj3 = {...obj1, ...obj2};
	
console.log(obj3);