package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static final int ERROR_VALUE = Integer.MIN_VALUE;
    private final int MIN_SIZE = 3;             // The minimum number of elements to make up a valid expression

    private final List<String> listOfValues;

    public Calculator() {
        listOfValues = new ArrayList<>();
    }

    public void push(String value) {
        listOfValues.add(value);
    }

    public int calculate() {
        // Check if the list is empty or the size is not larger than the minimum size
        if (listOfValues.isEmpty() || listOfValues.size() < MIN_SIZE) {
            return ERROR_VALUE;
        }

        int result = 0;

        // Pop the first 3 elements from the list
        String num1 = pop();
        String operator = pop();
        String num2 = pop();

        // Validate 3 elements to be numbers and operator
        boolean isValid = validateOperator(num1, operator, num2);

        if (isValid) {
            result += Integer.parseInt(num1);

            switch (operator) {
                case "+":
                    result += Integer.parseInt(num2);
                    break;
                case "-":
                    result -= Integer.parseInt(num2);
                    break;
                case "*":
                    result *= Integer.parseInt(num2);
                    break;
                case "/":
                    result /= Integer.parseInt(num2);
                    break;
                case "%":
                    result %= Integer.parseInt(num2);
                    break;
                case "pow":
                    result = (int) Math.pow(result, Integer.parseInt(num2));
                    break;
                case "Max":
                    result = Math.max(result, Integer.parseInt(num2));
                    break;
                case "Min":
                    result = Math.min(result, Integer.parseInt(num2));
                    break;
            }
        } else {
            return ERROR_VALUE;
        }

        // If the size after the 1st iteration is odd, the expression is invalid.
        if (listOfValues.size() % 2 != 0) {
            return ERROR_VALUE;
        }

        while (!listOfValues.isEmpty()) {
            // Pop the first 2 elements from the list
            operator = pop();
            num2 = pop();

            isValid = validateOperator(operator, num2);

            if (isValid) {
                switch (operator) {
                    case "+":
                        result += Integer.parseInt(num2);
                        break;
                    case "-":
                        result -= Integer.parseInt(num2);
                        break;
                    case "*":
                        result *= Integer.parseInt(num2);
                        break;
                    case "/":
                        result /= Integer.parseInt(num2);
                        break;
                    case "%":
                        result %= Integer.parseInt(num2);
                        break;
                    case "pow":
                        result = (int) Math.pow(result, Integer.parseInt(num2));
                        break;
                    case "Max":
                        result = Math.max(result, Integer.parseInt(num2));
                        break;
                    case "Min":
                        result = Math.min(result, Integer.parseInt(num2));
                        break;
                }
            } else {
                return ERROR_VALUE;
            }
        }
        return result;
    }

    private boolean validateOperator(String s1, String s2, String s3) {
        return isNum(s1) && isOperator(s2) && isNum(s3);
    }

    private boolean validateOperator(String s1, String s2) {
        return isOperator(s1) && isNum(s2);
    }

    private boolean isNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String s) {
        if (s == null || (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")
                && !s.equals("%") && !s.equals("pow") && !s.equals("Max") && !s.equals("Min"))) {
            return false;
        }
        return true;
    }

    // Pop the first element from the array list
    private String pop() {
        String result = listOfValues.get(0);
        listOfValues.remove(0);
        return result;
    }

    public void clearCalculator() {
        listOfValues.clear();
    }
}