package ru.ka.calculator;

 enum RomanNumber {
     I(1),
     IV(4),
     V(5),
     IX(9),
     X(10),
     XL(40),
     L(50),
     XC(90),
     C(100);


     int arabicNumber;

     RomanNumber(int arabicNumber) {
         this.arabicNumber = arabicNumber;

     }

     public int getArabicNumber() {
         return arabicNumber;
     }
 }
