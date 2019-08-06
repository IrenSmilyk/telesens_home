/*Напишите программу, которая:
        - считывает строку
        - выводит исходную строку
        - выводит количество и список слов, которые начинаются на букву 'd'*/

package telesens.academy.lesson03;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        String str = getString();
        System.out.print("Исходная строка: " + str);
        int count = getCount(str);
        System.out.print("Количество: " + count);
    }

    private static int getCount(String str) {
        String[] strArray = str.split("(\\.|\\s+|,|\\?|!|-)");
        int count = 0;
        System.out.println("\nСписок слов, которые начинаются на букву 'd':");
        int index = 1;
        for (String ss : strArray) {
            if (ss.startsWith("d")) {
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
