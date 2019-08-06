package telesens.academy.lesson05;

public class TestDate {
    public static void main(String[] args) {
        Date date = new Date();


        date.set(31,12,2012);
        System.out.println(date);
        date.nextDay();
        System.out.println(date);
        date.printData();
    }
}
