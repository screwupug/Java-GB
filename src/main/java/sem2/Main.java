package sem2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        symbolsInARow();
        lineCompression("aaabbcdd");
    }

    /*
    Дано четное число N (>0) и символы c1 и c2.
    Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1
     */
    public static void symbolsInARow() {
        Scanner scanner = new Scanner(System.in);
        String firstChar;
        String secondChar;
        int size;
        StringBuilder result = new StringBuilder();
        while (true) {
            try {
                System.out.print("Введите длину строки: ");
                size = Integer.parseInt(scanner.nextLine());
                if (size < 2) {
                    throw new Exception("Ошибка ввода! Попробуйте еще раз");
                }
                System.out.print("Введите первый символ: ");
                firstChar = scanner.nextLine();
                if (firstChar.length() > 1) {
                    throw new Exception("Ошибка ввода! Попробуйте еще раз");
                }
                System.out.print("Введите второй символ: ");
                secondChar = scanner.nextLine();
                if (secondChar.length() > 1) {
                    throw new Exception("Ошибка ввода! Попробуйте еще раз");
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Попробуйте еще раз");
            }
        }

        for (int i = 1; i < size + 1; i++) {
            if (i % 2 != 0) {
                result.append(firstChar);
            } else {
                result.append(secondChar);
            }
        }

        System.out.println(result);
    }

    /*
    Придумать алгоритм сжатия строки
    Пример: aaabbcdd
    */
    public static void lineCompression(String line) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char[] lineInChars = line.toCharArray();
        char buffer = lineInChars[0];

        for (int i = 1; i < lineInChars.length; i++) {
            if (lineInChars[i] == buffer) {
                count++;
            } else {
                if (count == 1) {
                    result.append(buffer);
                } else {
                    result.append(buffer).append(count);
                }
                buffer = lineInChars[i];
                count = 1;
            }
        }
        if (count == 1) {
            result.append(buffer);
        } else {
            result.append(buffer).append(count);
        }
        System.out.println(result);
    }
}
