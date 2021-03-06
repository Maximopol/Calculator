package com.maximopol.mycalc.logic;

import java.util.HashMap;


public class Operation {
    private static HashMap<Integer, String[]> operand_operation;
    private static HashMap<Integer, String[]> priority_operation;

    static {
        operand_operation = new HashMap<>();
        operand_operation.put(2, new String[]{"-", "+", "*", "/", "^"});
        operand_operation.put(1, new String[]{"sin", "cos", "tan", "√", "ln", "lg", "!"});

        priority_operation = new HashMap<Integer, String[]>();
        priority_operation.put(0, new String[]{"+", "-"});
        priority_operation.put(2, new String[]{"*", "/"});
        priority_operation.put(3, new String[]{"^", "√"});
        priority_operation.put(4, new String[]{"sin", "cos", "tan", "√", "ln", "lg", "!"});
    }


    private static boolean find(String[] operations, String operation) {
        boolean result = false;
        for (String value : operations) {
            if (operation.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static String[] getOperations(int operand) {
        return operand_operation.get(operand);
    }

    public static int getCountOfOperand(String operation) {
        int result = -1;
        for (int count : operand_operation.keySet()) {
            if (find(operand_operation.get(count), operation)) {
                result = count;
                break;
            }
        }
        return result;
    }

    public static int getPriority(String operation) {
        int result = -1;
        for (int priority : priority_operation.keySet()) {
            if (find(priority_operation.get(priority), operation)) {
                result = priority;
                break;
            }
        }
        return result;
    }

    public static double action(double first, double second, String operation) {
        double result = 0;
        switch (operation) {
            case "-":
                result = first - second;
                break;
            case "+":
                result = first + second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
            case "^":
                result = Math.pow(first, second);
                break;
        }
        return result;
    }

    public static double action(double first, String operation) {
        double result = 0;
        switch (operation) {
            case "sin":
                result = Math.sin(first);
                break;
            case "cos":
                result = Math.cos(first);
                break;
            case "tan":
                result = Math.tan(first);
                break;
            case "√":
                result = Math.sqrt(first);
                break;
            case "ln":
                result = Math.log(first);
                break;
            case "lg":
                result = Math.log10(first);
                break;
            case "!":
                result = getFactorial(first);
                break;
        }
        return result;
    }

    private static double getFactorial(double value) {
        int factorial1 = (int) value;
        double factorial2 = value - factorial1;

        for (int i = 1; i < Math.abs(value) - 1; i++) {
            factorial1 *= i;
        }
        factorial2 = Math.log10(factorial1) + factorial2 * Math.log10((int) value + 1);

        return Math.pow(10, factorial2);
    }

    public static boolean isDouble(String value) {
        boolean result = false;
        try {
            Double.parseDouble(value);
            result = true;
        } catch (Exception ignored) {
        }
        return result;
    }
}