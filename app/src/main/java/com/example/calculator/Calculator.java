package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static final int ERROR_VALUE = Integer.MIN_VALUE;
    private static final int MIN_SIZE = 3;             // The minimum number of elements to make up a valid expression

    private final List<String> listOfValues;

    public Calculator() {
        listOfValues = new ArrayList<>();
    }

    public void push(String value) {
        listOfValues.add(value);
    }

    public void clearCalculator() { listOfValues.clear(); }

    public int calculate() {
        // Validate that the size is larger than the minimum size
        if (listOfValues.size() < MIN_SIZE) {
            return ERROR_VALUE;
        }

        // Pop the first 3 elements from the list
        String num1 = pop();
        String operator = pop();
        String num2 = pop();

        // Validate 3 elements to be numbers and operator
        boolean isValid = validate(num1, operator, num2);

        if (!isValid) {
            return ERROR_VALUE;
        }

        int result = calculateExpression(Integer.parseInt(num1), operator, Integer.parseInt(num2));
        if (result == ERROR_VALUE) {
            return result;
        }

        // After 1st iteration, if the size of the list is an odd number, the expression is invalid.
        if (listOfValues.size() % 2 != 0) {
            return ERROR_VALUE;
        }

        while (!listOfValues.isEmpty()) {
            // Pop the first 2 elements from the list
            operator = pop();
            num2 = pop();

            isValid = validate(operator, num2);

            if (!isValid) {
                return ERROR_VALUE;
            }

            result = calculateExpression(result, operator, Integer.parseInt(num2));
            if (result == ERROR_VALUE) {
                return result;
            }
        }
        return result;
    }

    private boolean validate(String s1, String s2, String s3) { return isNum(s1) && isOperator(s2) && isNum(s3); }

    private boolean validate(String s1, String s2) {
        return isOperator(s1) && isNum(s2);
    }

    // Validate if it is a number
    private boolean isNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Validate if it is a string
    private boolean isOperator(String s) {
        return s != null && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")
                || s.equals("%") || s.equals("pow") || s.equals("Max") || s.equals("Min"));
    }

    // Pop the first element from the array list
    private String pop() {
        String result = listOfValues.get(0);
        listOfValues.remove(0);
        return result;
    }

    private int calculateExpression(int num1, String operator, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return ERROR_VALUE;
                }
            case "%":
                if (num2 != 0) {
                    return num1 % num2;
                } else {
                    return ERROR_VALUE;
                }
            case "pow":
                return (int) Math.pow(num1, num2);
            case "Max":
                return Math.max(num1, num2);
            case "Min":
                return Math.min(num1, num2);
            default:
                return ERROR_VALUE;
        }
    }
}