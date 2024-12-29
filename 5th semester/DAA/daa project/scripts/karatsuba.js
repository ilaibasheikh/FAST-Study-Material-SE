const levelSpacing = 100;
const siblingSpacing = 120;
let drawSteps = [];

function generateFileContent(length, numLength) {
    const min = Math.pow(10, numLength - 1);
    const max = Math.pow(10, numLength) - 1;
    return Array.from({ length }, () => Math.floor(Math.random() * (max - min + 1)) + min).join("\n");
}

function karatsuba(x, y, parent) {
    console.log(`Calculating Karatsuba for: ${x} and ${y}`);
    if (x < 10 || y < 10) {
        const result = x * y;
        console.log(`Base case: ${x} * ${y} = ${result}`);
        parent.children.push({ label: `${x} * ${y} = ${result}`, children: [] });
        return result;
    }

    const n = Math.max(x.toString().length, y.toString().length);
    const mid = Math.floor(n / 2);

    const a = Math.floor(x / Math.pow(10, mid));
    const b = x % Math.pow(10, mid);
    const c = Math.floor(y / Math.pow(10, mid));
    const d = y % Math.pow(10, mid);

    const node = { label: `Split (${x}, ${y})`, children: [] };
    parent.children.push(node);

    const p1 = karatsuba(a, c, node);
    const p2 = karatsuba(a + b, c + d, node);
    const p3 = karatsuba(b, d, node);

    const result = p1 * Math.pow(10, 2 * mid) + (p2 - p1 - p3) * Math.pow(10, mid) + p3;
    console.log(`Intermediate result for (${x}, ${y}): ${result}`);
    node.children.push({ label: `Result: ${result}`, children: [] });

    return result;
}

function calculateSubtreeWidth(node) {
    if (node.children.length === 0) {
        return siblingSpacing; 
    }
    return node.children
        .map(calculateSubtreeWidth)
        .reduce((a, b) => a + b, 0); 
}


function createTree(node, x, y) {
    const treeDiv = document.getElementById("tree");

    drawSteps.push(() => {
        const treeNode = document.createElement("div");
        treeNode.className = "node";
        treeNode.textContent = node.label;
        treeNode.style.left = `${x}px`;
        treeNode.style.top = `${y}px`;
        treeDiv.appendChild(treeNode);
    });

    const subtreeWidth = calculateSubtreeWidth(node);
    let childXStart = x - subtreeWidth / 2;

    node.children.forEach((child) => {
        const childSubtreeWidth = calculateSubtreeWidth(child);
        const childX = childXStart + childSubtreeWidth / 2;
        const childY = y + levelSpacing;

        drawSteps.push(() => {
            const line = document.createElement("div");
            line.className = "line";
            const dx = childX - x;
            const dy = childY - y;
            const angle = Math.atan2(dy, dx);
            const length = Math.sqrt(dx * dx + dy * dy);

            line.style.width = `${length}px`;
            line.style.height = "2px";
            line.style.transform = `rotate(${angle}rad)`;
            line.style.left = `${x}px`;
            line.style.top = `${y}px`;
            treeDiv.appendChild(line);
        });

        createTree(child, childX, childY);

        childXStart += childSubtreeWidth;
    });
}

function processNumbers(numbers) {
    console.log("Processing numbers:", numbers);

    let currentProduct = numbers[0];
    const treeDiv = document.getElementById("tree");
    const containerWidth = treeDiv.offsetWidth;
    const rootX = containerWidth / 2;

    (async () => {
        for (let i = 1; i < numbers.length; i++) {
            console.log(`Processing: ${currentProduct} * ${numbers[i]}`);
            const treeData = { label: `Start (${currentProduct}, ${numbers[i]})`, children: [] };

            currentProduct = karatsuba(currentProduct, numbers[i], treeData);

            await new Promise((resolve) => {
                setTimeout(() => {
                    treeDiv.innerHTML = "";
                    drawSteps = [];
                    createTree(treeData, rootX, 20);
                    resolve();
                }, 800);
            });

            await new Promise((resolve) => {
                const interval = setInterval(() => {
                    if (drawSteps.length === 0) {
                        clearInterval(interval);
                        resolve();
                    } else {
                        nextStep();
                    }
                }, 700);
            });
        }

        alert(`Final product: ${currentProduct}`);
        console.log(`Final product: ${currentProduct}`);
    })();
}


document.getElementById("file-upload").addEventListener("change", (event) => {
    const file = event.target.files[0];
    if (!file) {
        alert("No file selected!");
        return;
    }

    const reader = new FileReader();

    reader.onload = () => {
        const content = reader.result;
        const numbers = content
            .split(/\s+/)
            .map((num) => parseInt(num, 10))
            .filter((num) => !isNaN(num));

        if (numbers.length < 2) {
            alert("File must contain at least two valid numbers!");
            return;
        }

        const fileContentDiv = document.createElement("pre");
        fileContentDiv.textContent = `File Content:\n${numbers.join("\n")}`;
        document.getElementById("file-content").innerHTML = "";
        document.getElementById("file-content").appendChild(fileContentDiv);

        processNumbers(numbers);
    };

    reader.onerror = () => {
        alert("Error reading file!");
    };

    reader.readAsText(file);
});


document.getElementById("data-source").addEventListener("change", (e) => {
    const selectedValue = e.target.value;
    if (selectedValue === "file") {
        document.getElementById("random-inputs").style.display = "none";
        document.getElementById("file-input").style.display = "block";
        document.getElementById("file-selection").style.display = "none";
    } else {
        document.getElementById("random-inputs").style.display = "block";
        document.getElementById("file-input").style.display = "none";
        document.getElementById("file-selection").style.display = "none";
    }
});


document.getElementById("start-btn").addEventListener("click", async () => {
    const selectedSource = document.getElementById("data-source").value;

    if (selectedSource === "random") {
        const fileLength = parseInt(document.getElementById("file-length").value, 10);
        const numberLength = parseInt(document.getElementById("number-length").value, 10);

        if (isNaN(fileLength) || fileLength < 2) {
            alert("Please enter a valid file length (minimum 2)!");
            return;
        }

        if (isNaN(numberLength) || numberLength < 1) {
            alert("Please enter a valid number length (minimum 1)!");
            return;
        }

        const fileData = generateFileContent(fileLength, numberLength);

        const fileContentDiv = document.createElement("pre");
        fileContentDiv.textContent = `Generated Content:\n${fileData}`;
        document.getElementById("file-content").innerHTML = "";
        document.getElementById("file-content").appendChild(fileContentDiv);

        const numbers = fileData.split("\n").map((num) => parseInt(num, 10)).filter((num) => !isNaN(num));
        processNumbers(numbers);
    } else {
        alert("Please upload a file to proceed.");
    }
});

function nextStep() {
    if (drawSteps.length > 0) {
        const step = drawSteps.shift();
        step();
    }
}
