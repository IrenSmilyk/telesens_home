package telesens.academy.lesson09b;

import java.util.*;

public class DemoCollection {
    public static void main(String[] args) {
        String[] namesArray = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max" };
        //Создать список List из элементов массива и вывести на экран
        List<String> namesList = new ArrayList<>(Arrays.asList(namesArray));
        System.out.println(namesList);
        //Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
        namesList.add("Philip");
        namesList.add("Joseph");
        namesList.add("Leon");
        System.out.println(namesList);
        //Удалить из списка все имена: Veronica, Leonid и вывести на экран
        namesList.remove("Veronica");
        namesList.remove("Leonid");
        System.out.println(namesList);
        //Поменять имя Helen на Elizabet
        int index1 = namesList.indexOf("Helen");
        namesList.set(index1, "Elizabet");
        System.out.println(namesList);
        //Отсортировать имена по алфавиту и вывести на экран
        namesList.sort(String::compareTo);
        System.out.println(namesList);
        //Отсортировать имена в обратном порядке и вывести имена на экран
        Collections.reverse(namesList);
        System.out.println(namesList);
        //Перевести все первые символы в верхний регистр
        int count = 0;
        for (String s : namesList) {
            String first = Character.toString(s.charAt(0));
            String last = s.substring(1);
            String changed = first.toUpperCase() + last.toLowerCase();
            namesList.set(count, changed);
            count++;
        }
        System.out.println(namesList);
                //Вывести все имена, начинающиеся на букву A
        for (String s : namesList) {
            if (s.charAt(0) == 'A' || s.charAt(0) == 'a') {
                System.out.print(s + " ");
            }
        }

        //Проверить, содержит ли список имя Andry
        int index2 = namesList.indexOf("Andry");
        if (index2 > 0) System.out.println("\nСписок содержит имя Andry");
        else System.out.println("\nСписок не содержит имя Andry");

        //Удалить из списка все имена кроме Kate и Helen
        namesList.add("Helen");
        namesList.removeIf(nextName -> (!nextName.equals("Kate")&&!nextName.equals("Helen")));
        System.out.println(namesList);
    }
}
