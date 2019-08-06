/*Реализовать программу, которая:
        - считывает с клавиатуры строку
        - удаляет из строки все цифры
        - выводит исходную строку
        - выводит преобразованную строку
        - выводит список удаленных символов*/
package telesens.academy.lesson03;

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {
        String str = getString();
        StringBuilder arrayNumbers = new StringBuilder();
        StringBuilder arrayWords = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 47 && c < 58) {
                arrayNumbers.append(c);
            } else {
                arrayWords.append(c);
            }
        }
        System.out.print("Исходная строка: " + str);
        System.out.print("\nПреобразованная строка: " + arrayWords.toString());
        System.out.print("\nСписок удаленных символов: " + arrayNumbers.toString());
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}
