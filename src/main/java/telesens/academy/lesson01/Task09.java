/*Добавить в Java программу из предыдущего задания дополнительную возможность:
        a) При обычном запуске выводится только текст
        b) Если при запуске передать два аргумента:
        - префикс строки - 1-ый аргумент
        - постфикс строки - 2-й аргумент

        Результатом работы программы должен быть текст на консоли,
        каждая строка которого обрамлена префиксом и постфиксом

        с) Если	указан только один аргумент (префикс), он и предваряет строку*/

package telesens.academy.lesson01;

public class Task09 {
    public static void main(String[] args) {
        String pref = "";
        String post = "";
        if (args.length == 1) {
            pref = args[0];

        } else if (args.length == 2) {
            pref = args[0];
            post = args[1];
        }
        System.out.println(pref + " Привет! " + post);
        System.out.println(pref + " Это моя первая программа. Я пишу на Java. " + post);
        System.out.println(pref + " Программировать - это интересно. " + post);
        System.out.println(pref + " Моя цель-научиться писать тесты для автоматизации тестирования. " + post);
    }
}
