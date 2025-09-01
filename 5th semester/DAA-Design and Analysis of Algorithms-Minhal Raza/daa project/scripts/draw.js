// This file contains everything necessary to perform the drawings

import { answer, bruteForce, DyC, dividedArray, array3elements } from "./DyC.js";

export var stage = new createjs.Stage("canvas");
export var pointSize = 4;
export var coord = document.getElementById("coord");
window.addEventListener("resize", initializeCanvas);

var canvas = document.querySelector("#canvas");

var X, Y, W, H, r;              
canvas.height = 600;
canvas.width = 1000; 
// Adapts the canvas to different screen sizes
setTimeout(initializeCanvas, 100);
function initializeCanvas() {
    if (canvas && canvas.getContext) {
        var ctx1 = canvas.getContext("2d");
        if (ctx1) {
            var s = getComputedStyle(canvas);
            var w = s.width;
            var h = s.height;
                      
            W = canvas.width = w.split("px")[0];
            H = canvas.height = h.split("px")[0];
               
            X = Math.floor(W / 2);
            Y = Math.floor(H / 2);
            r = Math.floor(W / 3);
        }
    }
}

// Point class
// x -> X coordinate
// y -> Y coordinate
// draw -> CreateJS library structure for controlling point drawings
class Point {
    constructor(x, y, draw) {
        this.draw = draw;
        this.x = x;
        this.y = y;
    }
}

// The 'stop' variable controls whether animations should stop if interrupted for some reason
// (e.g., when clearing the canvas). 
// 0 -> indicates everything is fine, processes continue normally.
// 1 -> indicates some interruption occurred. Stops any ongoing animation.
export var stop = 0;

// The 'block' variable prevents adding new points while an animation is running
// 0 -> allows drawing to continue
// 1 -> blocks any new drawing or attempts to add a new point
var block = 0;
export function setBlock(value) {
    block = value;
}

// User click listener that executes to get the position and draw the point
canvas.addEventListener("click", getPosition);

// Arrays that hold the points. "shapes" contains them as entered, 
// while "shapesSort" holds them sorted or ready to be sorted
var shapes = [];
var shapesSort = [];

// Executes when the user clicks on the canvas, gets the coordinates, and creates the point
function getPosition(e) {
    if (block == 1) return;
    
    // initializeCanvas();
    // if (shapes.length >= 100) {
    //     alert("You have reached the maximum number of points");
    //     return;
    // }
    var rect = canvas.getBoundingClientRect();
    var x = e.clientX - rect.left;
    var y = e.clientY - rect.top;
    let c = new createjs.Shape();
    if (addPoint(x / 10, y / 10, c))
        drawCoordinates(shapes);
}

// Determines if one <Point> object is equal to another, or if they overlap
// 
// Receives two <Point> objects
function isEqual(p1, p2) {
    return ((Math.abs(p1.x - p2.x) < 1.7) && Math.abs(p1.y - p2.y) < 1.7) ? true : false;
}

// Checks if the point is already in the array
// 
// Receives a <Point> object
function isValid(point) {
    for (let i = 0; i < shapes.length; i++) {
        if (isEqual(point, shapes[i]))
            return false;
    }
    return true;
}

export function drawCoordinates(shapes) {
    stage.removeAllChildren();
    for (let i = 0; i < shapes.length; i++) {
        (shapes[i].draw).graphics.beginFill("#fff").drawCircle(shapes[i].x * 10, shapes[i].y * 10, pointSize);
        stage.addChild(shapes[i].draw);
        stage.update();
    }
}

var addedPoint = document.querySelector(".points");
function addPoint(x, y, c) {
    let point = new Point(x, y, c);

    if (isValid(point)) {
        shapes.push(point);
        shapesSort.push(point);
        y = canvas.height - y - 450;
        coord.innerHTML = `x: ${x.toFixed(2)} y: ${y.toFixed(2)}`;
        const p = document.createElement("p");
        p.innerHTML = `x: ${x.toFixed(2)} <br>y: ${y.toFixed(2)}`;
        p.classList.add("item__point");  
        addedPoint.appendChild(p); 
        return true;
    }

    return false;
}

document.getElementById('start_BF').addEventListener("click", start_BF);
document.getElementById('start_BFM').addEventListener("click", start_BF);
export function start_BF() {
    if (block == 1) return;
    
    let n = shapes.length;
    
    if (n < 2) {
        alert("Add at least 2 points");
        return;
    }

    coord.innerHTML = ("Processing...");
    stop = 0;
    block = 1;
    bruteForce(shapes, n, shapes);
}

document.getElementById('start_DyC').addEventListener("click", start_DyC);
document.getElementById('start_DyCM').addEventListener("click", start_DyC);
export function start_DyC() {
    if (block == 1) return;
    
    let n = shapesSort.length;

    if (n < 2) {
        alert("Add at least 2 points");
        return;
    }

    coord.innerHTML = "Processing...";
    stop = 0;
    block = 1;

    DyC(shapesSort, n);
}

document.getElementById('random').addEventListener("click", randomPoints);
document.getElementById('randomM').addEventListener("click", randomPoints);
export function randomPoints() {
    if (block == 1) return;
    
    // if (shapes.length >= 100) {
    //     alert("You have reached the maximum number of points");
    //     return;
    // }

    let n = 100 - shapes.length;

    for (let i = 0; i < n;) {
        let x = Math.random() * canvas.width;
        let y = Math.random() * canvas.height;
        console.log(x);
        console.log(y);
        let c = new createjs.Shape();

        if (addPoint(x / 10, y / 10, c)) {
            drawCoordinates(shapes);
            i++;
        }
    }
}

// Handle the file upload when the user clicks the upload button
document.getElementById('upload').addEventListener("click", uploadPoints);
document.getElementById('uploadM').addEventListener("click", uploadPoints);

export function uploadPoints() {
    // Trigger the file input to open the file dialog
    document.getElementById('fileInput').click();
}

// Handle file selection
document.getElementById('fileInput').addEventListener('change', function(event) {
    const file = event.target.files[0];  // Get the selected file
    if (!file) return;  // If no file is selected, return

    const reader = new FileReader();
    reader.onload = function(e) {
        const content = e.target.result;  // File content as text

        // Parse the file content (assuming points are separated by a comma)
        try {
            const points = parsePointFile(content);  // Parse the points
            if (Array.isArray(points)) {
                // Process and draw points on the canvas
                points.forEach(point => {
                    const x = point.x;  // Adjust coordinates (scale factor if needed)
                    const y = point.y;
                    console.log(x/10);
                    console.log(y/10);
                    let c = new createjs.Shape();
                    
                    // Add the point to the canvas using your addPoint logic
                    if (addPoint(x / 10, y / 10, c)) {
                        drawCoordinates(shapes);  // Ensure this function works with the uploaded points
                    }
                });
            }
        } catch (error) {
            alert("Error parsing file. Please ensure the file is in the correct format.");
        }
    };

    reader.readAsText(file);  // Read the selected file as text
});

// Function to parse the .txt file content
function parsePointFile(content) {
    const points = [];
    
    // Split the content into lines
    const lines = content.trim().split('\n');
    
    // Iterate over each line and parse the coordinates
    lines.forEach(line => {
        const [x, y] = line.split(',').map(coord => parseFloat(coord.trim()));
        
        // If both x and y are valid numbers, add the point to the array
        if (!isNaN(x) && !isNaN(y)) {
            points.push({ x, y });
        }
    });
    
    return points;
}


document.getElementById('restart').addEventListener("click", restart);
document.getElementById('restartM').addEventListener("click", restart);
export function restart() {
    block = 0;
    stop = 1;
    shapes.length = 0;
    shapesSort.length = 0;
    dividedArray.length = 0;
    array3elements.length = 0;
    var info = document.querySelectorAll(".item__point");
    for (let item of info) {
        item.remove();
    }
    coord.innerHTML = "";
    stage.removeAllChildren();
    initializeCanvas();
}
