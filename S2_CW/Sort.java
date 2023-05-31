package S2_CW;

import java.util.Arrays;

// быстрая сортировка
// линейный и бинарный поиск

import java.util.Random;

public class Sort {

    public static void main(String[] args) {

        int[] array = new int[10000];
        fillArray(array);

        // int[] bubbleArray = new int[10000];
        // fillArray(bubbleArray);
        // int[] bubbleArray = new int[10000];
        // fillArray(bubbleArray);

        directSort(array);
        // fillArray(array);

        // bubbleSort(array);
        // fillArray(array);

        // long startTime = quickSort(array, 0, array.length - 1);
        // System.out.println("QuickSort: " + (System.currentTimeMillis() - startTime));

        int a = array[new Random().nextInt(array.length)];
        int val = binarySearch(array, a, 0, array.length - 1);
        System.out.println("Binary: " + val);

        System.out.println();

        long start1 = linearFind(array, a);
        System.out.println("Linear: " + (System.nanoTime() - start1));

    }

    public static void fillArray(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt();
            // System.out.print(array[i] + " ");
        }
    }

    public static void directSort(int[] array) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        System.out.println("DirectSort: " + (System.currentTimeMillis() - start));
    }

    public static void bubbleSort(int[] array) {
        long start = System.currentTimeMillis();
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        System.out.println("BubbleSort: " + (System.currentTimeMillis() - start));
    }

    public static long quickSort(int[] array, int startPosition, int endPosition) {
        long start = System.currentTimeMillis();
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[startPosition + (endPosition - startPosition) / 2];

        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }

            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
        return start;
    }

    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;
        long start = System.nanoTime();

        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value) {
            min = midpoint + 1;
            // return binarySearch(array, value, midpoint + 1, max);
        } else if (array[midpoint] > value) {
            max = midpoint - 1;
        } else {
            System.out.println("HUHIU");
            return midpoint;}

    }

    public static long linearFind(int[] array, int value) {
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return start;
            }

        }
        return -1;

    }
}
