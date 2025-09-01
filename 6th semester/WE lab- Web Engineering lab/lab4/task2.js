function reverseString(str) {
    let reversedStr = str.split('').sort().reverse().join('');
    console.log("Reversed String :", reversedStr);
}
reverseString("Laiba");
