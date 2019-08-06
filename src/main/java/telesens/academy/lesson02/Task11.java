/*Проинициализировать одномерный массив произвольными целыми числами
        Вывести массив в виде, например:
        [3, 4, 9, 10, 34, 239, 8, 0, -3, 19, 17]
        a) используя цикл for
        b) используя цикл while*/

package telesens.academy.lesson02;

import java.util.Random;
import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {
        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int [] array = new int[length];
        Random ran = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]=ran.nextInt(100);
        }
        System.out.println("Массив, заполненный произвольными числами:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        int i=0;
        while (i<array.length){
           System.out.print(""+array[i] + " ");
           i++;
       }
    }
}
