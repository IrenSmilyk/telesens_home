/*Реализовать программу, которая:
        - считывает строку
        - меняет местами порядок символов (напр. "abcd" => "dcba")
        - выводит исходную строку
        - выводит перевернутую строку*/
package telesens.academy.lesson03;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        StringBuilder stringBuffer = new StringBuilder(scanner.nextLine());
        System.out.print("Исходная строка: "+stringBuffer);
        System.out.print("\nПеревернутая строка: "+stringBuffer.reverse());
    }
}
