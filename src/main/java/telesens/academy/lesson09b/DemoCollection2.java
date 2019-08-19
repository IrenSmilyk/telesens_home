/*
2) List
        a) создать список целых чисел
        b) наполнить список случайными целыми числами от 1 до 100 (размер списка 20 элементов)
        c) вывести список на экран
        d) вывести минимальное, максимально значения
        e) вывести сумму чисел на экран
        f) найти наиболее часто встречающееся число, вывести это число и кол-во повторений на экран
        (если чисел несколько с одинаковой частотой повторений, то вывести минимальное из них)
*/
package telesens.academy.lesson09b;

import java.util.*;

public class DemoCollection2 {
    public static void main(String[] args) {
        List<Integer> namesList = new ArrayList<>();
        List<Integer> namesList2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 20; i++) {
            Integer k = random.nextInt(100);
            namesList.add(k);
        }
        System.out.println(namesList);
        //вывести минимальное, максимально значения
        System.out.println("MAX= " + Collections.max(namesList));
        System.out.println("MIN= " + Collections.min(namesList));
        //вывести сумму чисел на экран
        System.out.println("SUM= " + namesList.stream().mapToInt(Integer::intValue).sum());
//найти наиболее часто встречающееся число, вывести это число и кол-во повторений на экран
//		(если чисел несколько с одинаковой частотой повторений, то вывести минимальное из
        Set<Integer> unique = new HashSet<>(namesList);
        int d=0;
        int k = 0;
        for (Integer x : unique) {
            d = Collections.frequency(namesList, x);
            if (d > 1) {
                namesList2.add(x);
                k = 1;
            }
        }
        if (k != 1) System.out.println("Повторяющихся цисел нет");
        else {
            System.out.println("Повторяющиеся числа: " + namesList2);
            System.out.println("Минимальное цисло из повторяющихся цисел: " + Collections.min(namesList2));
        }
    }
}
