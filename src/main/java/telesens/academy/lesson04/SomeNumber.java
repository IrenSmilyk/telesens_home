package telesens.academy.lesson04;

public class SomeNumber {
    private int n;

    //конструктор без параметров (по умолчанию инициализируем 0)
    SomeNumber() {
        this.n = 0;
    }

    //Конструктор, с одним параметром (int n)
    SomeNumber(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    void setN(int n) {
        this.n = n;
    }

    //Метод print(), который выводит строку, напр: "Число: 5"
    void print() {
        System.out.println("Число: " + n);
    }

    //// которые возвращает true, если число положительное и false, если число отрицательное
    boolean isPositive() {
        return n > 0;
    }

}
