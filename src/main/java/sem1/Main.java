package sem1;


import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        exerciseOne();
//        exerciseTwo();
    }

    private static void exerciseOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String userName = scanner.nextLine();
        System.out.printf("Привет, %s!%n", userName);
        scanner.close();
    }

    private static void exerciseTwo() {
        int[] array = new int[1000];
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 2);
        }
        System.out.println(Arrays.toString(array));
        for (int j : array) {
            if (j == 1) {
                count++;
            } else if (j == 0) {
                if (count != 0) {
                    list.add(count);
                }
                count = 0;
            }
        }
        list.add(count);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Collections.max(list).toString());
    }
}
