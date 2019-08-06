package telesens.academy.lesson05;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(Date date) {
        new Date(date.getDay(), date.getMonth(), date.getYear());
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void set(int day, int month, int year) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else System.out.println("Вы ввели неверный день!");
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else System.out.println("Вы ввели неверный месяц!");
        if (year >= 1 && year <= 4000) {
            this.year = year;
        } else System.out.println("Вы ввели неверный год!");
    }
}
