function isPalindrome(str) {
    const reversed = str.split('').reverse().join('');
    if (str === reversed) {
        console.log("string is a palindrome.");
    } else {
        console.log("string is not a palindrome.");
    }
}
isPalindrome("civic"); 
isPalindrome("laiba"); 
