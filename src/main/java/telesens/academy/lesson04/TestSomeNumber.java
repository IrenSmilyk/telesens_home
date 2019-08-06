/*Создайте класс TestSomeNumber, в котором продемонстрируйте работу класса SomeNumber
        на нескольких тестовых данных [-10, -1, 0, 1, 15]
        a) проверить работу конструкторов
        b) проверить работу метода setN();
        c) проверить работу метода isPositive();*/
package telesens.academy.lesson04;

public class TestSomeNumber {

    public static void main(String[] args) {
        SomeNumber someNumber = new SomeNumber(15);
        someNumber.print();
        printSomeNumber(someNumber);
        SomeNumber someNumber2 = new SomeNumber();
        someNumber2.setN(-1);
        someNumber2.print();
        printSomeNumber(someNumber2);
    }
    private static void printSomeNumber (SomeNumber someNumber){
        boolean number=someNumber.isPositive();
        if (number)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }
}
