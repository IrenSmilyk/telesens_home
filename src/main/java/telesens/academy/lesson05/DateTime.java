package telesens.academy.lesson05;

import java.util.Objects;

public class DateTime extends Date {
    private int hours;
    private int minutes;
    private int seconds;

    public DateTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public DateTime() {
    }

    public DateTime(DateTime dateTime) {
        new Date(dateTime.getHours(), dateTime.getMinutes(), dateTime.getSeconds());
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    //реализовать метод checkTime(int hour, int minute, int second), который проверяет существование введенного времени
    public boolean checkTime(int hours, int minutes, int seconds) {
        return ((hours >= 0 && hours <= 24) & (minutes >= 0 && minutes <= 60) & (seconds >= 0 && seconds <= 60));
    }

    /*модифицировать поля с помощью методов set
		- реализовать методы
    nextSecond();
    nextMinute();
    nextHour();
    которые увелечивают на единицу значение секунды, минуты и часа соответственно, при чем если кол-во часов достигается
			24, то должно увеличиться на единицу значение поля day из базового класса*/
    public int nextHour() {
        hours++;
        if (hours >= 24) {
            hours = 0;
            nextDay();
        }
        return hours;
    }

    public int nextMinutes() {
        minutes++;
        if (minutes >= 60) {
            minutes = 0;
            nextHour();
        }
        return minutes;
    }

    public int nextSecond() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            nextMinutes();
        }
        return seconds;
    }

    @Override
    public String toString() {
        return hours +":" + minutes +":" + seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DateTime dateTime = (DateTime) o;
        return hours == dateTime.hours &&
                minutes == dateTime.minutes &&
                seconds == dateTime.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hours, minutes, seconds);
    }

    public void  printTime() {
        System.out.println(hours+":" + minutes +":"+ seconds);
    }

    public void  printTime(boolean isTimeFormat12) {
        System.out.println(hours+":" + minutes +":"+ seconds);
    }
}
