package L1_CW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    public static void main(String[] args) {
        //List<Integer> availableDivider = findAvailableDivider(12);
        //List<Integer> availableDivider = findSimpleNumbers(100);
        //System.out.println(findSum(1));
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.printf("Fib number: %d\n Counter: %d", fib, counter.get());
        // for (Integer integer : availableDivider){
        //     System.out.println(integer);
        // }
        
    }

    public static List<Integer> findAvailableDivider(int number){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0){
                result.add(i);
            }
            
        }
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max){
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0){
                    simple = false;
                    break;
                }
            }
            if (simple){
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }

    public static double findSum(int sum){
        int counter = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == sum){
                        successResult++;
                    }
                    counter++;     
                }
                
            }

        }
        System.out.println("Counter: " + counter);
        return ((double) successResult) / ((double) counter);
    }

    public static int fib(int position, AtomicInteger counter){
        counter.incrementAndGet();
        
        if (position == 1){
            return 0;
        }
        if (position == 2){
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
    
}
