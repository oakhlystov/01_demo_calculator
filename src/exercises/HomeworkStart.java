package exercises;

import calculator.CalculatorMain;

public class HomeworkStart {
    public static void main(String[] args) {
        // массивы, числа и строки для подстановки в методы
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20 - 5);
        }

        int[][] array2 = new int[20][20];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                array2[i][j] = -10 + (int) (Math.random() * 20 + 1);
            }
        }

        String[] arrayStringsDiff = new String[20];
        String temp = "";
        for (int i = 0; i < array.length; i++) {
            switch (i) {
                case 2:
                case 7:
                case 10:
                    temp = "";
                    break;
                case 12:
                case 15:
                    temp = "Test " + i;
                    break;
                default:
                    for (int j = 0; j < Math.random() * 5; j++) {
                        temp = temp + "A";
                    }
                    break;
            }
            arrayStringsDiff[i] = temp;
        }

        int randomNumber = (int) (Math.random() * 20);

        // методы для вызова

        int sumElementsOnEvenPositions = NumbersArray.sumElementsOnEvenPositions(array);
        NumbersArray.replaceNegativeElementsByZero(array);
        int[] generateFibonacciNumbers = NumbersArray.generateFibonacciNumbers(randomNumber);
        int[] generatePrimeNumbers = NumbersArray.generatePrimeNumbers(randomNumber);
        NumbersArray.countNumbersWithEqualCountOfEvenAndOddDigits(array);
        NumbersArray.countNumbersWithOnlyUniqueDigits(array);
        NumbersArray.rotateArray(array2);
        NumbersArray.findDuplicates(array);
        StringsArray.findShortestString(arrayStringsDiff);
        StringsArray.findLongStrings(arrayStringsDiff);
        StringsArray.countStringsWithUniqueCharacters(arrayStringsDiff);
        String findStringWithDigitsOnly = StringsArray.findStringWithDigitsOnly(arrayStringsDiff); // строки 46, 48, 49 и 57 включены в переменные,
        CalculatorMain.calcGetResult(); // поскольку выдает ошибки, что результат не используется
    }
}