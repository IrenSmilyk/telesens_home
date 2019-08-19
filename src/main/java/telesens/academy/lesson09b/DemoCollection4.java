/*4) Представить данные о пользователях в виде ассоциативного массива (Map) (login / пароль) с предположением, что все логины пользователей разные.

        Написать метод:
        - print(Map<String, String> accounts, length) // который выводит данные о пользователях с длиной пароля длиннее length*/
package telesens.academy.lesson09b;

import java.util.HashMap;
import java.util.Map;

public class DemoCollection4 {
    public static void main(String[] args) {
        Map<String, String> credential = new HashMap<>();
        credential.put("Ira", "ira34");
        credential.put("jhhh", "ira3467");
        credential.put("ddddddd", "ira2542ff8");
        int length = 5;
        System.out.println("Пользователи с длиной пароля длиннее " + length + ":");
        print(credential, length);

    }

    static void print(Map<String, String> accounts, int length) {
        for (String value : accounts.values()) {
            Integer number = value.length();
            if (number > length) System.out.println(value);
        }
    }
}
