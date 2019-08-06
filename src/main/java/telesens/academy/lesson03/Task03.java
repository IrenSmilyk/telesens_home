/*Напишите программу, которая:
        - считывает строку
        - считывает подстроку
        - выводит исходные строку и подстроку и выводит кол-во вхождений строки в подстроку*/
package telesens.academy.lesson03;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = getString(scanner);
        String subStr = getSubString(scanner);
        System.out.print("Исходная строка: " + str);
        System.out.println("\nИсходная подстрока: " + subStr);
        System.out.print("Кол-во вхождений подстроки в строку: " + getCount(str, subStr));
    }

    private static int getCount(String str, String subStr) {
        String[] splitArray = str.split(subStr, -1);
        return splitArray.length - 1;
    }

    private static String getSubString(Scanner scanner) {
        System.out.print("Введите подстроку: ");
        return scanner.nextLine();
    }

    private static String getString(Scanner scanner) {
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}
