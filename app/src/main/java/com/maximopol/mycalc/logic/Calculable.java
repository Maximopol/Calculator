package com.maximopol.mycalc.logic;

import java.util.Stack;

public class Calculable {

    private static Stack<Double> stackOfNumbers;
    private static Stack<String> stackOfOperations;

    static {
        stackOfNumbers = new Stack<>();
        stackOfOperations = new Stack<>();
    }

    private static void addOperation(String operation) {
        String prev_operation;
        int prev_priority,
                current_priority;
        if (!stackOfOperations.isEmpty()) {

            prev_operation = stackOfOperations.pop();

            prev_priority = Operation.getPriority(prev_operation);
            current_priority = Operation.getPriority(operation);

            if (prev_priority > current_priority) {
                calculate(prev_operation);
                addOperation(operation);
            } else {
                stackOfOperations.push(prev_operation);
                stackOfOperations.push(operation);
            }

        } else {
            stackOfOperations.push(operation);
        }
    }

    private static void calculate(String operation) {
        if (Operation.getCountOfOperand(operation) == 2) {
            double second = stackOfNumbers.pop(),
                    first = stackOfNumbers.pop();

            stackOfNumbers.push(Operation.action(first, second, operation));
        } else {
            double first = stackOfNumbers.pop();
            stackOfNumbers.push(Operation.action(first, operation));
        }
    }

    public static double run(String[] str) {

        for (String value : str) {
            if (Operation.isDouble(value)) {
                stackOfNumbers.push(Double.parseDouble(value));
            } else {
                addOperation(value);
            }
        }

        while (!stackOfOperations.isEmpty()) {
            calculate(stackOfOperations.pop());
        }

        return stackOfNumbers.pop();
    }
}