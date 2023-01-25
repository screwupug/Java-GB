package homework2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        lineBuilder();
        System.out.println(isPalindrome());
    }

    public static boolean isPalindrome() {
        Scanner scanner = new Scanner(System.in);
        String line;
        String reversedLine;
        while (true) {
            try {
                System.out.print("Введите слово/фразу для проверки на палиндром: ");
                line = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }
        }
        reversedLine = new StringBuilder(line).reverse().toString();
        return line.equalsIgnoreCase(reversedLine);
    }

    public static void lineBuilder() {
        StringBuilder line = new StringBuilder();
        line.append("TEST ".repeat(100));
        writeInAFile(line.toString());
    }

    public static void writeInAFile(String line) {
        // В условии только одна строка, поэтому поток чтения можно не открывать
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/homework2/test.txt"))) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
