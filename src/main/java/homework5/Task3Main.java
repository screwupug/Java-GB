package homework5;

import java.util.Arrays;

public class Task3Main {
    public static void main(String[] args) {
        int[] array = new int[] {10, 5, 3, 2, 13, 19};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        int size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, i, size);
        }

        for (int i = size - 1; i >= 0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i);
        }
    }

    public static void heapify(int[] array, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (i != largest) {
            int buff = array[i];
            array[i] = array[largest];
            array[largest] = buff;
        }

    }
}
