package calculator;

import java.util.Objects;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        calcGetResult();
    }

    public static String calcGetResult() {
        Scanner scanner = new Scanner(System.in);
        String firstNumStr = "";
        String secondNumStr = "";
        String result;

        System.out.println("Введите первое целое число:");
        if (scanner.hasNext()) {
            firstNumStr = scanner.next();
        }

        String operation;
        System.out.println("Введите одну из операций: + , - , * , /");
        operation = scanner.next();

        System.out.println("Введите второе целое число:");
        if (scanner.hasNextInt()) {
            secondNumStr = scanner.next();
        }

        if (!firstNumStr.matches("[-+]?\\d+")) { // проверяем , если не целое число или лишние символы, то ошибка и выходим
            System.out.println("Error");
            return "Error";
        }

        if (!secondNumStr.matches("[-+]?\\d+")) {
            System.out.println("Error");
            return "Error";
        }

        switch (operation) { // делаем вычисление и отодаем результат
            case "+":
                result = String.valueOf(Integer.parseInt(firstNumStr) + Integer.parseInt(secondNumStr));
                break;
            case "-":
                result = String.valueOf(Integer.parseInt(firstNumStr) - Integer.parseInt(secondNumStr));
                break;
            case "/":
                if (Objects.equals(secondNumStr, "0")) { // деление на 0 дает ошибку
                    System.out.println("Error: divide by zero.");
                    return "Error";
                } else {
                    result = String.valueOf(Integer.parseInt(firstNumStr) / Integer.parseInt(secondNumStr));
                }
                break;
            case "*":
                result = String.valueOf(Integer.parseInt(firstNumStr) * Integer.parseInt(secondNumStr));
                break;
            default:
                System.out.println("Error"); // если знак действия неверный, то ошибка и выход
                return "Error";
        }
        result = "Result = " + result;
        System.out.println(result);
        return result;
    }
}