package telesens.academy.lesson05;

import telesens.academy.lesson08.IllegalDateException;

import java.util.Objects;

public class Date {
    private int day;
    private int month;
    private int year;

    //конструткор инициированный 1 января 1970
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    //конструктор инициализирует все поля public Date(int day, int month, int year)
    public Date(int day, int month, int year) throws IllegalDateException {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            throw new IllegalDateException();
        }
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalDateException();
        }
        if (year > 0) {
            this.year = year;
        } else {
            throw new IllegalDateException();
        }
    }

    //конструктор копирования public Date(Date date)
    public Date(Date date) throws IllegalDateException {
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

    /*реализовать возможность установки нового значения времени с помощью методов:
    set(int day, int month, int year);
    set(Date date);
    в первом случае проверять корректность полей: day, month, year*/

    public void set(int day, int month, int year) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else System.out.println("Вы ввели неверный день!");
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else System.out.println("Вы ввели неверный месяц!");
        if (year >= 1 && year <= 9999) {
            this.year = year;
        } else System.out.println("Вы ввели неверный год!");
    }

    public void set(Date date) {
        if (date.day >= 1 && date.day <= 31) {
            this.day = date.day;
        } else System.out.println("Вы ввели неверный день!");
        if (date.month >= 1 && date.month <= 12) {
            this.month = date.month;
        } else System.out.println("Вы ввели неверный месяц!");
        if (date.year >= 1 && date.year <= 9999) {
            this.year = date.year;
        } else System.out.println("Вы ввели неверный год!");
    }

    /*реализовать методы:
    			nextDay();
    			nextMonth();
    			nextYear();
    			которые увеличивают на единицу значение дня, месяца и года соответственно*/
    public int nextDay() {
        day++;
        if (day == 32) {
            day=1;
            nextMonth();
        }
        return day;
    }

    public int nextMonth() {
        month++;
        if (month == 13) {
            month=1;
            nextYear();
        }
        return month;
    }

    public int nextYear() {
        return year++;
    }

    @Override
    public String toString() {
        return day +"." + month +"." + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    /*реализовать метод printData();
    который выводит дату в форматированном виде, напр. 25.01.2017*/
    public void  printData() {
        System.out.println(day+"." + month +"."+ year);
    }

}
