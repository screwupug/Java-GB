package homework1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(isLeapYear(1800) + "\n");
        minAndMaxInArray();
        System.out.println();
        moveElementsInArray(3);
    }

    private static boolean isLeapYear(int year) {
        ArrayList<Integer> listOfYears = new ArrayList<>();
        for (int i = 4; i < 2029; i += 4) {
            if (i % 100 != 0 || i % 400 == 0) {
                listOfYears.add(i);
            }
        }
        for (Integer integer : listOfYears) {
            if (year == integer) {
                return true;
            }
        }
        return false;
    }

    private static void minAndMaxInArray() {
        int[] array = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1, 101);
        }
        int min = array[0];
        int max = array[0];
        System.out.println(Arrays.toString(array));
        for (int item : array) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
        }
        System.out.printf("Min - %d%nMax - %d%n", min, max);
    }

    private static void moveElementsInArray(int value) {
        int[] array = new int[50];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1, 4);
        }
        int positionToMove = array.length - 1;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (i >= positionToMove) {
                break;
            }
            if (array[i] == value) {
                while (true) {
                    if (array[positionToMove] == value) {
                        positionToMove--;
                    } else {
                        int temp = array[i];
                        array[i] = array[positionToMove];
                        array[positionToMove] = temp;
                        positionToMove--;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
