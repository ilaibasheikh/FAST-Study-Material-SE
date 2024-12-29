import { setBlock, stop, pointSize, coord, stage, drawCoordinates } from "./draw.js";

// This file contains the algorithms necessary to perform the animations, as well
// as the solution to the problem

const red = 'ff2d2d', green = '39f533', orange = 'ffaf54', blue = '7697ff';

var ctx = canvas.getContext("2d");
// Helper function to calculate and return the distance between 2 points
// 
// Receives 2 <Point> objects
export function dist(p1, p2) {
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + 
                     (p1.y - p2.y) * (p1.y - p2.y));
}

export function answer(array, n) {
    let min_dist = [0, 0, Number.MAX_VALUE];
    stage.removeAllChildren();
    // stage.update();

    for (let i = 0; i < n; i++) {
        giveColor(array[i], green);
        for (let j = i + 1; j < n; j++) {
            let current = dist(array[i], array[j]);
            if (current < min_dist[2]) {
                min_dist[0] = array[i];
                min_dist[1] = array[j];
                min_dist[2] = current;
            }
        }
    }

    giveColor(min_dist[0], blue);
    giveColor(min_dist[1], blue);
    drawLine(min_dist[0], min_dist[1]);
    coord.innerHTML = `The minimum distance is: ${min_dist[2].toFixed(2)}`;
}

function giveColor(point, color) {
    (point.draw).graphics.beginFill(`#${color}`).drawCircle(point.x * 10, point.y * 10, pointSize);
    stage.addChild(point.draw);
    stage.update();
}

function drawLine(from, to) {
    ctx.globalCompositeOperation = 'destination-over';
    ctx.strokeStyle = '#fff';
    ctx.lineWidth = 2;
    ctx.moveTo(from.x * 10, from.y * 10);
    ctx.lineTo(to.x * 10, to.y * 10);
    ctx.stroke();
    ctx.globalCompositeOperation = 'source-over';
}

export function bruteForce(array, n, array2) {
    var i = 0, j;

    drawCoordinates(array2);
    // Draw the division of each section of 3 points DyC, and prevent drawing
    // if 2 or 3 points are drawn for the bruteForce animation
    if (n != array2.length) {
        var start = array[0].x * 10, 
            end = array[n - 1].x * 10 - start;
        drawDiv(start, end);
    }
    
    // Controls iterating over all points and processing them (orange)
    var id_i = setTimeout(function drawOrange() {
        // Each drawing goes on top of the previous one
        ctx.globalCompositeOperation = 'source-over';

        // If the process is interrupted for any reason, stop the animation
        if (stop == 1) {
            clearTimeout(id_i);
            return 0;
        }

        // Base case
        // If it finishes evaluating all points, draw the line between the closest ones
        // and stop the loop
        if (n == i) {
            clearTimeout(id_i);
            if (n == array2.length) {
                answer(array2, n);
            }
            setBlock(0);
            return;
        }

        // Color the point that will be processed in orange.
        giveColor(array[i], orange);
        j = i + 1;
        i++;

        var id_j = setTimeout(function drawRed() {
            stage.update();
            // Stop the animation if the process is interrupted
            if (stop == 1) {
                clearTimeout(id_j);
                return 0;
            }

            // If this condition is met, it means the point currently being processed has
            // already been compared with all others
            if (n == j) {
                clearTimeout(id_j);
                // Mark its state as "processed" (green)
                giveColor(array[i - 1], green);
                // Continue with the next "iteration"
                id_i = setTimeout(drawOrange, 200);
                return;
            }

            // Color in (red) one by one the points that are being compared with the point in process
            giveColor(array[j], red);

            // Draw the line between the point in process (orange) and the ones it is being compared with
            drawLine(array[i - 1], array[j]);

            // Recolor the points back to white
            for (let p = j; p < n; p++) {
                (array[p].draw).graphics.beginFill("#fff").drawCircle(array[p].x * 10, array[p].y * 10, 4);
                stage.addChild(array[p].draw);
            }
            
            j++;
            // Move to the next "iteration"
            id_j = setTimeout(drawRed, 200);
        }, 200);
    }, 200);
}

// Sort the array by x coordinate
function sortX(array) {
    return array.sort(function(a, b) {
        return a.x - b.x;
    });
}

export function DyC(array, n) {
    sortX(array);

    divide(array, n);

    drawDivision(dividedArray, array);
    let u = 0;
    setBlock(1);

    let id_m = setTimeout(function callBruteForce() {
        if (u == array3elements.length || stop == 1) {
            clearTimeout(id_m);
            answer(array, n);
            setBlock(0);
            return;
        }

        bruteForce(array3elements[u], array3elements[u].length, array);

        for (let i = 0; i < u; i++) {
            let colored = array3elements[i];
            for (let point of colored) {
                giveColor(point, green);
            }
        }
        u++;
        id_m = setTimeout(callBruteForce, 2300); 
        
    }, 400 * dividedArray.length + 1000);
}

export var dividedArray = [];
export var array3elements = [];

function divide(array, n) {
    dividedArray.push(array);
    if (n <= 3) {
        array3elements.push(array);
        return;
    }

    let mid = Math.floor(n / 2);
    divide(array.slice(0, mid), mid);
    divide(array.slice(mid, n), n - mid);
}

function drawDivision(array) {
    let n = 0;
    const m = array.length;

    let id_d = setTimeout(function division() {
        if (n == m || stop == 1) {
            clearTimeout(id_d);
            return;
        }

        let p = array[n].length,
            start = array[n][0].x * 10, 
            end = array[n][p - 1].x * 10 - start;

        let ind = drawDiv(start, end);
        stage.removeChildAt(ind);
        n++;
        id_d = setTimeout(division, 400);    
    }, 400);
}

function drawDiv(start, end) {
    let div = new createjs.Shape();
    div.graphics.beginFill("rgba(0, 175, 255, 0.30)").drawRect(start, 0, end, canvas.height);
    stage.addChild(div);
    stage.update();
    return stage.getChildIndex(div);
}
