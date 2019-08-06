/*В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую на экран результат деления q на w с остатком.
        Пример вывода программы (для случая, когда в q хранится 21, а в w хранится 8):
        21 / 8 = 2 и 5 в остатке

        - прочитать число q
        - прочитать число w

        - вывести число q
        - вывести число w

        - вывести результат целочисленного деления
        - вывести остаток от деления

        Пример:
        q = 21;
        w = 8;
        q/w = 2;
        r = 5 (остаток)

        числа (q и w) передать в программу извне любым способом:
        - как аргументы метода main.
        - предложить пользователю ввести значения*/

package telesens.academy.lesson02;

import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число q: ");
        int q = scanner.nextInt();
        System.out.print("Введите число w: ");
        int w = scanner.nextInt();

        System.out.println("q = " + q);
        System.out.println("w = " + w);
        System.out.println("Результат целочисленного деления q/w = " + q / w);
        System.out.println("Остаток от деления q/w= " + q % w);
    }
}
