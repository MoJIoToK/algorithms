/*
 * 3) Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */
package S2_HW;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = {60, 5, 7, 1000, 3, 555, 23, 99};

        System.out.println("Исходный массив: ");
        PrintArray(arr);

        System.out.println();
        System.out.println("Отсортированный массив: ");
        heapSort(arr);
        PrintArray(arr);
    }
    
    public static void heapSort(int[] arr) {
        int n = arr.length;
        //Создание дерева:
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);   
        }
        // Создание самой сортировки
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i); 
        }
    }

    public static void heapify(int[] arr, int i, int n) {//максимальный heap - maxheap(во главе макс элемент)
        int left = i * 2 + 1; // левая ветка
        int right = i * 2 + 2; // правая ветка
        int largest = i;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (i != largest)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, largest, n);
        }
    }

    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        } 
    }

}
