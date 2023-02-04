package homework2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
//        lineBuilder();
        System.out.println(isPalindrome());
    }

    public static boolean isPalindrome() {
        String line;
        System.out.print("Введите слово/фразу для проверки на палиндром: ");
        line = new Scanner(System.in).nextLine();
        char[] array = line.toLowerCase().toCharArray();
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            if (array[i] != array[j]) {
                return false;
            }
        }
        return true;

    }

    public static String lineBuilder() {
        return "TEST".repeat(100);
    }

    public static void writeInAFile() {
        // В условии только одна строка, поэтому поток чтения можно не открывать
        String line = lineBuilder();
        String path = "src/main/java/homework2/test.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success");
    }


}
