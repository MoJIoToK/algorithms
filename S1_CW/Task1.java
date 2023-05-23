/*1.Необходимо написать алгоритм, считающий сумму всех чисел 
от 1 до N. Согласно свойствам линейной сложности,
количество итераций цикла будет линейно изменяться
относительно изменения размера N.
*/

// Сложность O(n)

/*2. Написать алгоритм поиска простых чисел (делятся только на себя и
на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
вложенный for, что явно говорит о квадратичной сложности, на этом
стоит акцентировать внимание 

3. Необходимо написать алгоритм поиска всех доступных комбинаций
(посчитать количество) для количества кубиков K с количеством граней N.

4. - Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
    - Считаем, что 1 и 2 значения последовательности равны 1.
    - Искать будем по формуле On=On-1+On-2 что предполагает использовать
рекурсивного алгоритма.

5. Пишем алгоритм поиска нужного числа последовательности Фибоначчи, но в этот
раз откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам
линейную сложность, т.к. вычисление каждого из чисел последовательности будет
происходить ровно 1 раз.
1.Вариантов решения может быть несколько, но нужно предложить студентам
считать последовательность с первого числа и далее до тех пор, пока не доберемся
до нужного номера. При этом значение предыдущих элементов нужно сохранять,
чтобы не приходилось вычислять заново, как это происходило при рекурсивном
методе.

*/

package S1_CW;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Task1 {

    public static void main(String[] args) {

/*        int number = 100, cnt = 0;

        //1
        // int sum = (number + 1) * number / 2;

        long start = System.nanoTime();
        int sum = 0;

        for (int i = 1; i <= number; i++, sum += i)
            ;
        long end = System.nanoTime();
        System.out.println(sum + " " + (end - start));


        // 2
        ArrayList<Integer> simpleNumbers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                cnt ++;
                if (i % j == 0) {
                    
                    simple = false;
                    break;
                }
            }
            if (simple) {
                simpleNumbers.add(i);
            }
        }
        System.out.println(simpleNumbers);
        System.out.println(cnt);


        // 3
        int numberCube = 4, numberSide = 6, cnt = 0;
        ArrayList<String> simpleList = new ArrayList<>();
        for (int i1 = 1; i1 <= numberSide; i1++) {
            for (int i2 = 1; i2 <= numberSide; i2++) {
                for (int i3 = 1; i3 <= numberSide; i3++) {
                    for (int i4 = 1; i4 <= numberSide; i4++) {
                        simpleList.add(" " + i1 + i2 + i3 + i4);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(simpleList);
        System.out.println(cnt);
*/
        AtomicLong counter1 = new AtomicLong(0);
        long start = System.currentTimeMillis();

        System.out.println(fib(40, counter1));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(counter1 + "\n");

        counter1 = new AtomicLong(0);
        start = System.currentTimeMillis();
        System.out.println(findFib(40, counter1));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(counter1);

    }

    public static int fib(int number, AtomicLong counter) {
        counter.incrementAndGet();
        if (number <= 2) return 1;
        return fib(number - 1, counter) + fib(number - 2, counter);
        
    }

    public static int findFib(int number, AtomicLong counter) {
        
        if (number <= 2) return 1;
        int f1 = 1, f2 = 1;
        int f = f1 + f2;
        while (number-- > 3){
            f1 = f2;
            f2 = f;
            f = f1 + f2;
            counter.incrementAndGet();
        }
        return f;

    }

}
