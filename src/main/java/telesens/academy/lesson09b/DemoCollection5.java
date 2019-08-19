/*5) Есть два списка email:
        set1 = {"account@gmail.com", "my-mail@yandex.ru", "abc@yahoo.com", "mail@gmail.com"}
        set2 = {"student@gmail.com", "my-mail@yandex.ru", "private-mail@yahoo.com", "mail-for-spam@gmail.com"}

        a) вывести на экран email, которые встречаются в двух списках
        b) вывести на экран email из первого списка, которых нет во втором
        c) вывести на экран email из двух списков, но чтобы не было повторений
        (Использовать коллекцию Set)*/

package telesens.academy.lesson09b;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoCollection5 {
    public static void main(String[] args) {
        String[] set1 = {"account@gmail.com", "my-mail@yandex.ru", "abc@yahoo.com", "mail@gmail.com"};
        String[] set2 = {"student@gmail.com", "my-mail@yandex.ru", "private-mail@yahoo.com", "mail-for-spam@gmail.com"};
        Set<String> email1 = new HashSet<String>(Arrays.asList(set1));
        Set<String> email2 = new HashSet<String>(Arrays.asList(set2));
        //вывести на экран email, которые встречаются в двух списках
       /* Set<String> email3 = new HashSet<String>(email2);
        email3.retainAll(email1);
        System.out.println(email3);*/
        email1.stream().filter(email2::contains).collect(Collectors.toList()).forEach(System.out::println);
        //вывести на экран email из первого списка, которых нет во втором
        //??????????????????
        //вывести на экран email из двух списков, но чтобы не было повторений
        email1.addAll(email2);
        System.out.println(email1);


    }
}
