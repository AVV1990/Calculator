package ru.ka.calculator;

 enum Operator {

     ADDITION('+'),
     SUBTRACTION('-'),
     MULTIPLICATION('*'),
     DIVIDING('/');

     char operator;

     Operator(char operator) {
         this.operator = operator;
     }


     public static Operator findByOperator(char operator) {
         Operator[] operators = Operator.values();
         for (Operator o : operators) {
             if (o.getOperator() == operator) {
                 return o;
             }
         }
         throw new MyException (operator + " не соответствует ни одному из предложенных операций (+, -, /, *) ");
     }

     public char getOperator() {
         return operator;
     }

 }

