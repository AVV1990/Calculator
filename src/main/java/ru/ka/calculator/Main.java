package ru.ka.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите математическую операцию через пробелы: ");
                String input = scanner.nextLine();
                System.out.println("Ответ " + calc(input));
                System.out.println();
            }
        }

    }

    public static String calc(String input) {

        Validator.isInputCorrect(input);

        int result = 0;

        String[] arrString = input.trim().split("\\s");
        int firstOperand = 0;
        int secondOperand = 0;
        char operatorInInput = arrString[1].charAt(0); // это символ

        Operator operator = Operator.findByOperator(operatorInInput);

        boolean romanExpression = false;

        try {
            firstOperand = ArabicRomanNumberConverter.romanToInt(arrString[0]);
            secondOperand = ArabicRomanNumberConverter.romanToInt(arrString[2]);
            romanExpression = true;

        } catch (Exception e) {
            try {
                firstOperand = Integer.parseInt(arrString[0]);
                secondOperand = Integer.parseInt(arrString[2]);
            } catch (Exception exception) {
            }

        }

        switch (operator) {
            case ADDITION:
                result = firstOperand + secondOperand;
                break;
            case SUBTRACTION:
                result = firstOperand - secondOperand;
                break;
            case MULTIPLICATION:
                result = firstOperand * secondOperand;
                break;
            case DIVIDING:
                result = firstOperand / secondOperand;
                break;

        }

        if (romanExpression) {
            return ArabicRomanNumberConverter.intToRoman(result);
        }

        String resultAsString = Integer.toString(result);
        return resultAsString;

    }
}
