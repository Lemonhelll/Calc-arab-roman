import java.util.Scanner;

public class Calculator {

    static boolean arabicNumber = false;
    static boolean romanNumber = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String op ;
        String[] redact = input.split("\\W");
        String[] operator = input.split("\\w");
        if (redact.length == 2) {
            op = operator[operator.length - 1];

            int firstNumber = getNumber(redact[0]);
            int secondNumber = getNumber(redact[1]);
            int result;

            if (romanNumber && arabicNumber) {  // Проверяем условие, чтобы числа были разных систем счисления
                System.out.println("Используются одновременно разные системы счисления");
            } else if (firstNumber > 10 || secondNumber > 10) {  // Проверяем условие входящие числа не должны быть больше 10
                System.out.println("Числа должны быть больше меньше 10");
            } else if (op.equals("+")) {
                result = firstNumber + secondNumber;
                if (arabicNumber) {
                    System.out.println(result);
                } else {
                    System.out.println(convertNumToRoman(result));
                }
            } else if (op.equals("-")) {
                result = firstNumber - secondNumber;
                if (arabicNumber) {
                    System.out.println(result);
                } else if (firstNumber - secondNumber < 0) {
                    System.out.println("В римской системе нет отрицательных чисел"); // Проверяем условие, что римские не могут быть отрицательными
                } else {
                    System.out.println(convertNumToRoman(result));
                }
            } else if (op.equals("*")) {
                result = firstNumber * secondNumber;
                if (arabicNumber) {
                    System.out.println(result);
                } else {
                    System.out.println(convertNumToRoman(result));
                }
            } else if (op.equals("/")) {
                result = firstNumber / secondNumber;
                if (arabicNumber) {
                    System.out.println(result);
                } else {
                    System.out.println(convertNumToRoman(result));
                }
            }
        } else if (redact.length < 2){
            System.out.println("Строка не является математической операцией");
        } else {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }

    // метод преобразования римских чисел в арабские
    private static int getNumber(String number) {
        switch (number) {
            case "I" -> {
                romanNumber = true;
                return 1;
            }
            case "II" -> {
                romanNumber = true;
                return 2;
            }
            case "III" -> {
                romanNumber = true;
                return 3;
            }
            case "IV" -> {
                romanNumber = true;
                return 4;
            }
            case "V" -> {
                romanNumber = true;
                return 5;
            }
            case "VI" -> {
                romanNumber = true;
                return 6;
            }
            case "VII" -> {
                romanNumber = true;
                return 7;
            }
            case "VIII" -> {
                romanNumber = true;
                return 8;
            }
            case "IX" -> {
                romanNumber = true;
                return 9;
            }
            case "X" -> {
                romanNumber = true;
                return 10;
            }
            default -> {
                arabicNumber = true;
                return Integer.parseInt(number);
            }
        }
    }

    // Метод преобразования арабских чисел в римские
    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"Римские числа не могут принимать значения ниже единицы", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }

}
