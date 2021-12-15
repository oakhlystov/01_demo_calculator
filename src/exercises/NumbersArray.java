package exercises;

public class NumbersArray {

    // task 1
    public static int sumElementsOnEvenPositions(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i = i + 2) { // суммируем эл-ты на четных позициях (индексах)
            sum = sum + array[i];
        }
        return sum;
    }

    // task 2
    public static void replaceNegativeElementsByZero(int[] array) {
        for (int i = 0; i < array.length; i++) { // если эл-т меньше 0 то перезаписываем его нулем
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
    }

    // task 3
    public static int[] generateFibonacciNumbers(int count) {
        int[] fibArray = new int[count];
        if (count == 1) {
            fibArray[count - 1] = 0;
        } else if (count == 2) {
            fibArray[count - 2] = 0;
            fibArray[count - 1] = 1; // стандартные маленькие входные данные на 1 и 2 числа
        } else {
            fibArray[0] = 0;
            fibArray[1] = 1; // так же стандартные, от них отталкиваемся
            for (int i = 2; i < count; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2]; // по формуле вычисляем след. эл-т и записываем
            }
        }
        return fibArray;
    }

    // task 4
    public static int[] generatePrimeNumbers(int count) {
        int[] finArray = new int[count];
        finArray[0] = 2; // стандартно начинается с двойки
        int iterNum = 3; // след. цифра после 2
        for (int i = 1; i < count; i++) {
            while (getPrimeStatus(finArray, i, iterNum)) { // пока число делится без остатка на предыдущие, счетчик вкл.
                iterNum++;
            }
            finArray[i] = iterNum; // если не делится, то записываем эту цифру в рез.массив
            iterNum++;
        }
        return finArray;
    }

    public static boolean getPrimeStatus(int[] tempArray, int tempIndex, int actualNum) {
        for (int i = 0; i < tempIndex; i++) { // проходим по всем цифрам до последней i из основного метода
            int tempElement = tempArray[i];
            boolean primeStatus = actualNum % tempElement == 0; // если делится без остатка,
            if (primeStatus) { // то в основном методе пропустим и будем исследовать следующее
                return true;
            }
        }
        return false;
    }

    // task 5 Найти количество чисел с равным числом четных и нечетных цифр.
    public static int countNumbersWithEqualCountOfEvenAndOddDigits(int[] array) {
        int countNumbers = 0;
        int counterEven = 0;
        int counterOdd = 0;
        for (int i : array) {
            String tempStr = String.valueOf(i);
            for (int j = 0; j < tempStr.length(); j++) {
                if (String.valueOf(tempStr.charAt(j)).equals("-")) { // убираем знак отрицания у эл-та, если он есть
                    tempStr = tempStr.substring(1);
                }
                int tempInt = Integer.parseInt(String.valueOf(tempStr.charAt(j))); // проверка на четное или нечетное и подсчет каждого
                if (tempInt % 2 == 0) {
                    counterEven++;
                } else {
                    counterOdd++;
                }
            }
            if (counterEven == counterOdd) {
                countNumbers++; // если одинаковое кол-во чет и нечет, то в счетчик таких эл-в для результата
            }
            counterEven = 0;
            counterOdd = 0;
        }
        return countNumbers;
    }

    // task 6
    public static int countNumbersWithOnlyUniqueDigits(int[] array) {
        int countUniqueNumbers = 0;
        for (int i : array) {
            boolean isUnique = true;
            String tempStr = String.valueOf(i);
            if (String.valueOf(tempStr.charAt(0)).equals("-")) { // убираем знак отрицания у эл-та
                tempStr = tempStr.substring(1);
            }
            if (tempStr.length() > 1) {
                for (int j = 0; j < tempStr.length() - 1; j++) {
                    for (int k = j + 1; k < tempStr.length(); k++) {
                        String tempStrToCompare1 = String.valueOf(tempStr.charAt(j)); // проходим по всем эл-м и сравниваем каждый с каждым,
                        String tempStrToCompare2 = String.valueOf(tempStr.charAt(k)); // если не равны, то выходим на след. i-й эл-т
                        if (!tempStrToCompare1.equals(tempStrToCompare2)) {  // сама проверка
                            isUnique = false;
                            break;
                        }
                    }
                    if (!isUnique) {
                        break;
                    }
                }
            } else {
                countUniqueNumbers++; // для уникальных вкл. счетчик
            }
            if (isUnique) {
                countUniqueNumbers++;
            }
        }
        return countUniqueNumbers;
    }

    // task 7
    public static int[][] rotateArray(int[][] array) {
        int lengthA = array.length;
        int lengthB = array[0].length;
        int[][] finArray = new int[lengthB][lengthA];
        for (int i = 0; i < lengthA; i++) {
            for (int j = 0; j < lengthB; j++) {
                finArray[j][lengthA - 1 - i] = array[i][j];
            }
        }
        return finArray;
    }

    // task 8

    public static int[][] findDuplicates(int[] array) {
        Integer[] tempIntArray = new Integer[array.length];
        int tempArrayIndex = 0;
        for (int value : array) {
            if (isInTempArray(tempIntArray, value)) { // проверяем, что эл-т встречается хотя бы 2 раза в массиве
                continue;
            }
            int count = 0;
            for (int i : array) {
                if (value == i) { // считаем, сколько раз встречается i-й эл-т
                    count++;
                }
            }
            if (count > 1) {
                tempIntArray[tempArrayIndex] = value; // запоминаем неуникальные числа
                tempArrayIndex++;
            }
        }
        int[] duplicatedArray = new int[tempArrayIndex]; // переписываем неуникальные числа в соразмерный массив
        for (int i = 0; i < tempArrayIndex; i++) {
            duplicatedArray[i] = tempIntArray[i];
        }
        int[][] finArray = new int[duplicatedArray.length][2]; // результирующий массив и его размер
        int finArrayIndex = 0;
        for (int j : duplicatedArray) { // проверяем, сколько раз каждое неуникальное число встречается в оригинальном массиве
            int counter = 0;
            for (int k : array) {
                if (j == k) {
                    counter++;
                }
            }
            if (counter > 1) {
                finArray[finArrayIndex][0] = j; // записываем финальный результат
                finArray[finArrayIndex][1] = counter;
                finArrayIndex++;
            }
        }

        return finArray;
    }

    public static boolean isInTempArray(Integer[] tempArray, int num) { // возвращает true если переданный эл-т уже был отмечен как неуникальный
        for (Integer integer : tempArray) {
            if (String.valueOf(integer).equals(String.valueOf(num))) {
                return true;
            }
        }
        return false;
    }
}