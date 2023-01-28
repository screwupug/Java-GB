package homework3;

import jdk.jfr.StackTrace;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] a = {2, 9, 5, 4, 8, 1, 6};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

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
//        System.out.println("mergeSort - left " + Arrays.toString(left));
//        System.out.println("mergeSort - right " + Arrays.toString(right));
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

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
                arrayCount++;
            } else {
                array[arrayCount] = right[rightCount];
                rightCount++;
                arrayCount++;
            }
        }
        if (leftCount < leftSize) {
            System.arraycopy(left, leftCount, array, arrayCount, leftSize - leftCount);
        }
        if (rightCount < rightSize) {
            System.arraycopy(right, rightCount, array, arrayCount, rightSize - rightCount);
        }
//        System.out.println(Arrays.toString(array));

    }


//    public static int[] merge(int[] array) {
//        int firstBufferSize = array.length / 2;
//        int secondBufferSize = array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1;
//        int[] firstBuffer = new int[firstBufferSize];
//        int[] secondBuffer = new int[secondBufferSize];
//        int[] result = new int[array.length];
//        int countForFirstBuffer = 0;
//        int countForSecondBuffer = 0;
//        int countForResult = 0;
//        System.arraycopy(array, 0, firstBuffer, 0, firstBufferSize);
//        System.out.println(Arrays.toString(firstBuffer));
//        System.arraycopy(array, firstBufferSize, secondBuffer, 0, secondBufferSize);
//        System.out.println(Arrays.toString(secondBuffer));
//        while (countForFirstBuffer < firstBufferSize && countForSecondBuffer < secondBufferSize) {
//            if (firstBuffer[countForFirstBuffer] < secondBuffer[countForSecondBuffer]) {
//                result[countForResult] = firstBuffer[countForFirstBuffer];
//                countForFirstBuffer++;
//                countForResult++;
//            } else if (secondBuffer[countForSecondBuffer] < firstBuffer[countForFirstBuffer]) {
//                result[countForResult] = secondBuffer[countForSecondBuffer];
//                countForSecondBuffer++;
//                countForResult++;
//            }
//        }
//        while (countForFirstBuffer < firstBufferSize) {
//            result[countForResult] = firstBuffer[countForFirstBuffer];
//            countForFirstBuffer++;
//            countForResult++;
//        }
//        while (countForSecondBuffer < secondBufferSize) {
//            result[countForResult] = secondBuffer[countForSecondBuffer];
//            countForSecondBuffer++;
//            countForResult++;
//        }
//        System.out.println(Arrays.toString(result));
//        return result;
//
//    }
}
