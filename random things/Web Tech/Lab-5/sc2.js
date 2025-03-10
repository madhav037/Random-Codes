function calc() {
    let answer = document.getElementById('answer').value;
    let ansArray = parseInput(answer);
    let finalAns = evaluateExpression(ansArray);
    console.log("final ans = " + finalAns);
    return finalAns;
}

function parseInput(input) {
    let output = [];
    let currentNumber = "";

    for (let i = 0; i < input.length; i++) {
        let char = input[i];

        if (isNumber(char) || char === ".") {
            currentNumber += char;
        } else {
            if (currentNumber !== "") {
                output.push(parseFloat(currentNumber));
                currentNumber = "";
            }
            output.push(char);
        }
    }

    if (currentNumber !== "") {
        output.push(parseFloat(currentNumber));
    }

    return output;
}

function evaluateExpression(expression) {
    let operators = [];
    let operands = [];

    for (let i = 0; i < expression.length; i++) {
        let token = expression[i];

        if (isNumber(token)) {
            operands.push(token);
        } else if (isOperator(token)) {
            while (
                operators.length > 0 &&
                hasPrecedence(token, operators[operators.length - 1])
                ) {
                let operator = operators.pop();
                let operand2 = operands.pop();
                let operand1 = operands.pop();
                let result = applyOperation(operator, operand1, operand2);
                operands.push(result);
            }
            operators.push(token);
        }
    }

    while (operators.length > 0) {
        let operator = operators.pop();
        let operand2 = operands.pop();
        let operand1 = operands.pop();
        let result = applyOperation(operator, operand1, operand2);
        operands.push(result);
    }

    return operands[0];
}

function isNumber(value) {
    return !isNaN(parseFloat(value)) && isFinite(value);
}

function isOperator(value) {
    return value === "+" || value === "-" || value === "*" || value === "/";
}

function hasPrecedence(operator1, operator2) {
    if (operator2 === "(" || operator2 === ")") {
        return false;
    }
    if ((operator1 === "*" || operator1 === "/") && (operator2 === "+" || operator2 === "-")) {
        return false;
    }
    return true;
}

function applyOperation(operator, operand1, operand2) {
    switch (operator) {
        case "+":
            return operand1 + operand2;
        case "-":
            return operand1 - operand2;
        case "*":
            return operand1 * operand2;
        case "/":
            return operand1 / operand2;
        default:
            return 0;
    }
}
