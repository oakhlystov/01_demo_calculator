package exercises;

public class StringsArray {

    // task 1
    public static String findShortestString(String[] array) {
        int min = 0; // задаем наим. длину и перебираем массив для подставновки реальной какой-либо ненулевой мин. длины
        for (String value : array) {
            if (value.length() > 0) {
                min = value.length();
                break;
            }
        }
        String minArrayElem = null; // записываем элемент и его длину
        for (String s : array) {
            if (s.length() < min && s.length() != 0) {
                min = s.length();
                minArrayElem = s;
            }
        }
        return minArrayElem;
    }

    // task 2
    public static String[] findLongStrings(String[] array) {
        int avgLength = 0; // для средней длины
        int counter = 0; // счетчик кол-ва эл-в
        for (String s : array) {
            avgLength = avgLength + s.length(); // записываем сумму длин
        }
        avgLength = avgLength / array.length; // вычисляем сред. длину
        for (String s : array) {
            if (s.length() > avgLength) {
                counter++; // считаем кол-во эл-в более средней длины
            }
        }
        int k = 0;
        String[] finStrings = new String[counter];
        for (int i = 0; i < counter; i++) {
            if (array[i].length() > avgLength) {
                finStrings[k] = array[i] + "=" + array[i].length(); // если длина больше сред., то записываем эл-т и длину
                //System.out.print(finStrings[k] + ", ");
                k++;
            }
        }

        return finStrings;
    }

    // task 3
    public static String findStringWithDigitsOnly(String[] row) {
        String resultStr = null;
        int counter = 0;
        for (String s : row) {
            if (s.matches("\\d+")) { // проверяем , что эл-т число
                if (counter != 2) { // если записан 0 или 1 эл-т, то записываем, иначе выход
                    resultStr = s;
                    counter++;
                } else {
                    break;
                }
            }
        }
        return resultStr;
    }

    // task 4
    public static int countStringsWithUniqueCharacters(String[] array) {
        int counter = 0;
        String strToChars;
        for (int i = 0; i < array.length - 1; i++) { // сверяем строку i со строками j
            boolean flag = false;
            if (array[i].length() > 0) { // если строка пустая, то проверяем каждый символ одной строки на дубль
                strToChars = array[i];
                for (int j = i + 1; j < strToChars.length(); j++) {
                    flag = strToChars.charAt(i) != strToChars.charAt(j); // отмечаем, если символы уникальны
                }
            }
            if (flag) {
                counter++; //подсчитываем кол-во, если отметили
            }
        }
        return counter;
    }
}