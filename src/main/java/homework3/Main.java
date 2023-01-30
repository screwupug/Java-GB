package homework3;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 9, 5, 4, 8, 1, 6};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
        deleteEvenNumbers();
        minMaxAverage();
        deleteRepeats();
    }

    // Сортировка слиянием (дробление массива с помощью рекурсии)
    public static void mergeSort(int[] array) {
        int size = array.length;
        if (size == 1) {
            return;
        }
        int middle = size / 2;
        int[] left = new int[middle];
        int[] right = new int[size - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < size; i++) {
            right[i - middle] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    // Сортировка слиянием (слияние массивов + сортировка)
    private static void merge(int[] array, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int leftCount = 0;
        int rightCount = 0;
        int arrayCount = 0;

        while (leftCount < leftSize && rightCount < rightSize) {
            if (left[leftCount] < right[rightCount]) {
                array[arrayCount] = left[leftCount];
                leftCount++;
            } else {
                array[arrayCount] = right[rightCount];
                rightCount++;
            }
            arrayCount++;
        }
        if (leftCount < leftSize) {
            System.arraycopy(left, leftCount, array, arrayCount, leftSize - leftCount);
        }
        if (rightCount < rightSize) {
            System.arraycopy(right, rightCount, array, arrayCount, rightSize - rightCount);
        }
    }

    // Генератор коллекций
    public static ArrayList<Integer> generateArray(int size) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(101));
        }
        return list;
    }

    // Задание 1
    public static void deleteEvenNumbers() {
        ArrayList<Integer> list = generateArray(10);
        for (Integer elem : list) {
            System.out.printf("%d ", elem);
        }
        list.removeIf(integer -> integer % 2 == 0);
        System.out.println();
        for (Integer s : list) {
            System.out.print(s + " ");
        }
    }

    // Задание 2
    public static void minMaxAverage() {
        ArrayList<Integer> list = generateArray(10);
        Collections.sort(list);
        int sum = 0;
        for (Integer s : list) {
            System.out.print(s + " ");
            sum += s;
        }
        System.out.println();
        System.out.printf("Min - %d\n", list.get(0));
        System.out.printf("Max - %d\n", list.get(list.size() - 1));
        System.out.printf("Average - %d\n", sum / list.size());
    }

    // Задание 3
    public static void deleteRepeats() {
        String[] planets = new String[]{
                "Меркурий", "Венера", "Земля",
                "Марс", "Юпитер", "Сатурн",
                "Уран", "Нептун"
        };
        Random rnd = new Random();
        ArrayList<String> list = new ArrayList<>();
        int listSize = rnd.nextInt(10, 26);
        for (int i = 0; i < listSize; i++) {
            list.add(planets[rnd.nextInt(planets.length)]);
        }

        Collections.sort(list);
        String repeat = list.get(0);
        for (String item : list) {
            System.out.printf("%s ", item);
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(repeat)) {
                list.remove(list.get(i--));
            } else {
                repeat = list.get(i);
            }
        }
        System.out.println();
        for (String item : list) {
            System.out.printf("%s ", item);
        }
    }
}
