package L2_CW;

public class Heapsort {

    public static void main(String[] args) {

        int[] array = new int[] { 4, 12, 500, 3, 9, 69, 1, 8596, 7, 2 };

        Heapsort(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
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
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
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
        if(rootIndex != largest){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            heapify(array, heapSize, largest);
        }
        // рекурсивное преобразуем в двоичную кучу затронутое поддерево
        
        
    }
    
}
