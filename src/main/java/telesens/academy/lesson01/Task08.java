/*Написать Java программу, которая выводит на консоль следующий текст (в несколько строк):
        (Для каждого нового предложения использовать отдельный вызов print или println)

        PeterПривет!
        PeterЭто моя первая программа. Я пишу на Java.
        Программировать - это интересно.
        Моя цель - ...
        (любой текст)*/

package telesens.academy.lesson01;

public class Task08 {

    public static void main(String[] args) {
        if (args.length == 1) {
            String name = args[0];
            System.out.println(name + " Привет!");
            System.out.println(name + " Это моя первая программа. Я пишу на Java.");
            System.out.println("Программировать - это интересно.");
            System.out.println("Моя цель-научиться писать тесты для автоматизации тестирования.");
        } else {
            System.out.println("Привет!");
            System.out.println("Это моя первая программа. Я пишу на Java.");
            System.out.println("Программировать - это интересно.");
            System.out.println("Моя цель-научиться писать тесты для автоматизации тестирования.");
        }
    }
}
