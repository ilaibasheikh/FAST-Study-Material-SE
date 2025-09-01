// 1. Basic JavaScript Problems

// FizzBuzz
function fizzBuzz() {
    for (let i = 1; i <= 100; i++) {
        let output = '';
        if (i % 3 === 0) output += 'Fizz';
        if (i % 5 === 0) output += 'Buzz';
        console.log(output || i);
    }
}
fizzBuzz();

// Reverse a String
function reverseString(str) {
    return str.split('').reverse().join('');
}

// Palindrome Check
function isPalindrome(str) {
    let reversed = str.split('').reverse().join('');
    return str === reversed;
}

// Factorial of a Number
function factorial(n) {
    return n === 0 ? 1 : n * factorial(n - 1);
}

// Find Largest/Smallest Number in an Array
function findLargest(arr) {
    return Math.max(...arr);
}
function findSmallest(arr) {
    return Math.min(...arr);
}

// 2. Array Manipulation

// Remove Duplicates from an Array
function removeDuplicates(arr) {
    return [...new Set(arr)];
}

// Find the Missing Number
function findMissingNumber(arr, n) {
    let expectedSum = (n * (n + 1)) / 2;
    let actualSum = arr.reduce((sum, num) => sum + num, 0);
    return expectedSum - actualSum;
}

// Two Sum Problem
function twoSum(arr, target) {
    let map = new Map();
    for (let num of arr) {
        if (map.has(target - num)) {
            return [target - num, num];
        }
        map.set(num, true);
    }
    return [];
}

// Merge Two Sorted Arrays
function mergeSortedArrays(arr1, arr2) {
    return [...arr1, ...arr2].sort((a, b) => a - b);
}

// 3. String Manipulation

// Count Vowels in a String
function countVowels(str) {
    return (str.match(/[aeiou]/gi) || []).length;
}

// Anagram Check
function isAnagram(str1, str2) {
    return str1.split('').sort().join('') === str2.split('').sort().join('');
}

// Longest Word in a String
function longestWord(sentence) {
    return sentence.split(' ').reduce((longest, word) => word.length > longest.length ? word : longest, '');
}

// Capitalize First Letter of Each Word
function capitalizeWords(sentence) {
    return sentence.replace(/\b\w/g, char => char.toUpperCase());
}

// 4. Mathematical Problems

// Prime Number Check
function isPrime(n) {
    if (n < 2) return false;
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return false;
    }
    return true;
}

// Fibonacci Series
function fibonacci(n) {
    let fib = [0, 1];
    for (let i = 2; i < n; i++) {
        fib.push(fib[i - 1] + fib[i - 2]);
    }
    return fib;
}

// GCD and LCM
function gcd(a, b) {
    return b === 0 ? a : gcd(b, a % b);
}
function lcm(a, b) {
    return (a * b) / gcd(a, b);
}

// 5. Logical and Algorithmic Problems

// Binary Search
function binarySearch(arr, target) {
    let left = 0, right = arr.length - 1;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (arr[mid] === target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

// Sorting Algorithms

// Bubble Sort
function bubbleSort(arr) {
    let len = arr.length;
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }
    return arr;
}

// Selection Sort
function selectionSort(arr) {
    for (let i = 0; i < arr.length; i++) {
        let minIndex = i;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) minIndex = j;
        }
        [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
    }
    return arr;
}

// Find the Second Largest Number
function secondLargest(arr) {
    let first = -Infinity, second = -Infinity;
    for (let num of arr) {
        if (num > first) {
            second = first;
            first = num;
        } else if (num > second && num !== first) {
            second = num;
        }
    }
    return second;
}

// Check for Balanced Parentheses
function isBalanced(str) {
    let stack = [];
    let pairs = { '(': ')', '[': ']', '{': '}' };
    for (let char of str) {
        if (pairs[char]) stack.push(char);
        else if (Object.values(pairs).includes(char)) {
            if (pairs[stack.pop()] !== char) return false;
        }
    }
    return stack.length === 0;
}
