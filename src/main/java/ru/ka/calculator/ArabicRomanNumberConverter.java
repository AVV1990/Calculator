package ru.ka.calculator;

 class ArabicRomanNumberConverter {

     public static int romanToInt(String s) {
         int sum = 0;
         int i;

         for (i = 0; i < s.length() - 1; i++) {

             sum += checkNextNumber(
                     RomanNumber.valueOf(s.substring(i, i + 1)), // это первый символ
                     RomanNumber.valueOf(s.substring(i + 1, i + 2)) // это второй   символ

             );
         }
         sum += RomanNumber.valueOf(s.substring(i, i + 1)).getArabicNumber();

         return sum;
     }


     public static int checkNextNumber(RomanNumber currentRomanLetter, RomanNumber nextRomanLetter) {
         if (currentRomanLetter == RomanNumber.I && (nextRomanLetter == RomanNumber.V || nextRomanLetter == RomanNumber.X)) {
             return -1;
         } else if (currentRomanLetter == RomanNumber.X && (nextRomanLetter == RomanNumber.L || nextRomanLetter == RomanNumber.C)) {
             return -10;
         }

         else {
             return currentRomanLetter.getArabicNumber();
         }
     }

     public static String intToRoman(int number) {

         String s = "";
         RomanNumber[] romanNumbers = RomanNumber.values();

         for (int i = romanNumbers.length; i > 0; i--) {

             while (number >= romanNumbers[i - 1].getArabicNumber()) {
                 s += romanNumbers[i - 1];
                 number -= romanNumbers[i - 1].getArabicNumber();
             }
         }

         return s;
     }
}
