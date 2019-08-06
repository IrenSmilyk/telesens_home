/*Написать программу ввода с клавиатуры последовательно 3 чисел. Вывести
        минимальное максимальное и средние значения*/

package telesens.academy.lesson02;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        System.out.print("Введите три числа:");
        Scanner scanner = new Scanner(System.in);
        int[] numbersArray = new int[3];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = scanner.nextInt();
        }
        float average;
        float sum = 0;
        for (int value : numbersArray) {
            sum += value;
        }
        average = sum / numbersArray.length;
        System.out.printf("Среднее значение: %.2f", average);

        int max = numbersArray[0];
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] > max) {
                max = numbersArray[i];
            }
        }
        System.out.println("\nМаксимальное число: " + max);
        int min = numbersArray[0];
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] < min) {
                min = numbersArray[i];
            }
        }
        System.out.println("минимальное число: " + min);
    }
}

