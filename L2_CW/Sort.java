package L2_CW;

import java.rmi.registry.LocateRegistry;

public class Sort {

    public static void main(String[] args) {

        int[] array = new int[] { 4, 12, 500, 3, 9, 69, 1, 8596, 7, 2  };

        // bubbleSort(array);
        // directSort(array);
        //insertSort(array);
        Heapsort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void bubbleSort(int[] array) {

        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);

    }

    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void sort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[startPosition + (endPosition - startPosition) / 2];
        // do{
        // while(array[leftPosition] < pivot){

        // }
        // }

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
            sort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            sort(array, startPosition, rightPosition);
        }

    }

    public static void Heapsort(int[] array) {
        // построение кучи (перегруппировка массива)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // премещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // вызываем функцию heapify на уменьшенной куче
            heapify(array, i, 0);
            
        }
    }

    public static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // наибольший эелемент как корень
        int leftChild = 2 * rootIndex + 1; // левый ребенок
        int rightChild = 2 * rootIndex +2; // правый 

        // если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }

        // если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        // если самый большой элемент не корень
        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // рекурсивное преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
        
        
    }

}
