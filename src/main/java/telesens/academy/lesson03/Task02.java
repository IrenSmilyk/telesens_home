/*Напишите программу, которая:
        - считывает строку
        - выводит исходную строку
        - выводит количество и список, которые заканчиваются буквами 'ED'*/
package telesens.academy.lesson03;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {
        String str = getString();
        System.out.print("Исходная строка: "+str);
        int count = getCount(str);
        System.out.print("Количество: "+count);
    }

    private static int getCount(String str) {
        String[] strArray = str.split("(\\.|\\s+|,|\\?|!|-)");
        int count = 0;
        System.out.println("\nСписок слов, которые заканчиваются буквами 'ED':");
        int index = 1;
        for (String ss : strArray) {
            if (ss.endsWith("ED")) {
                count++;
                System.out.println(index + ") " + ss);
                index++;
            }
        }
        return count;
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}
