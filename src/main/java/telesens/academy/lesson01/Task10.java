/*Написать Java программу, которая выводит на консоль следующую фигуру:
        *
        **
        ***
        ****
        *****
        *******/

package telesens.academy.lesson01;

public class Task10 {

    public static void main(String[] args) {
        for (int i = 1; i <7; i++) {
            for (int a = 0; a < i; a++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
