package ru.ka.calculator;

 class Validator {

     private final static String ROMAN_TYPE = "Roman";
     private final static String ARABIC_TYPE = "Arabic";


     public static boolean isInputCorrect(String input) {

         int firstOperand;
         int secondOperand;
         String firstOperandType;
         String secondOperandType;

         String[] arrInput = input.trim().split("\\s");

         char operator = arrInput[1].charAt(0); // это символ

         if (arrInput.length != 3) {
             throw new MyException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *). Математическую операцию нужно ввести через пробелы");
         }

         try {
             firstOperand = ArabicRomanNumberConverter.romanToInt(arrInput[0]);
             firstOperandType = ROMAN_TYPE;

         } catch (Exception ignore) {
             try {
                 firstOperand = Integer.parseInt(arrInput[0]);
                 firstOperandType = ARABIC_TYPE;

             } catch (Exception e) {
                 throw new MyException("Первый операнд не соответствует ни арабскому, ни римскому системам счисления");
             }
         }

         try {
             secondOperand = ArabicRomanNumberConverter.romanToInt(arrInput[2]);
             secondOperandType = ROMAN_TYPE;

         } catch (Exception ignore) {
             try {
                 secondOperand = Integer.parseInt(arrInput[2]);
                 secondOperandType = ARABIC_TYPE;

             } catch (Exception e) {
                 throw new MyException("Второй операнд не соответствует ни арабскому, ни римскому системам счисления");
             }
         }

         if (
                 operator != Operator.ADDITION.getOperator() &&
                         operator != Operator.SUBTRACTION.getOperator() &&
                         operator != Operator.MULTIPLICATION.getOperator() &&
                         operator != Operator.DIVIDING.getOperator()) {

             throw new MyException("Оператор не соответствует ни одному из предложенных операций (+, -, /, *)");
         }


         if ((firstOperandType.equals(ROMAN_TYPE) && secondOperandType.equals(ARABIC_TYPE)) || (firstOperandType.equals(ARABIC_TYPE) && secondOperandType.equals(ROMAN_TYPE))) {
             throw new MyException("Используются одновременно разные системы счисления");
         }


         if (firstOperand > 10 || secondOperand > 10) {
             throw new MyException("Введите числа от 1 до 10 включительно");
         }

         if (firstOperand < 1 || secondOperand < 1) {
             throw new MyException("Введите числа от 1 до 10 включительно");
         }


         if (firstOperandType.equals(ROMAN_TYPE) && secondOperandType.equals(ROMAN_TYPE)) {


             if (firstOperand % secondOperand == firstOperand && operator == '/') {
                 throw new MyException("В римской системе счисления нет 0");
             }

             if (firstOperand == secondOperand && operator == '-') {
                 throw new MyException("В римской системе счисления нет 0");
             }

             if (firstOperand < secondOperand && operator == '-') {
                 throw new MyException("В римской системе счисления нет отрицательных чисел");
             }
         }

         return true;
     }
 }
