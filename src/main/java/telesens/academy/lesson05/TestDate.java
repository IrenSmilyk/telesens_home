package telesens.academy.lesson05;

import telesens.academy.lesson08.IllegalDateException;
import telesens.academy.lesson08.IllegalTimeException;

public class TestDate {
    public static void main(String[] args) throws IllegalDateException, IllegalTimeException {
        /*Date date = new Date();
        date.set(31,12,2012);
        System.out.println(date);
        date.nextDay();
        System.out.println(date);
        date.printData();*/

        /*new Date(1, 1, 2012);
        new Date(17, 2, 2019);
        new Date(29, 2, 2020);
        new Date(31, 1, 1999);
        new Date(13, 6, 1681);*/
        /*new Date(-1, 1, 2012); 	// отрицательный день
        new Date(31, 2, 2019); 	// большое значение для дня
        new Date(29, 2, 2019); 	// не высокосный год
        new Date(31, 13, 1999); 	// 13 месяца не существует
        new Date(0, 06, 1681);*/
        /*new DateTime(12, 12, 12);
        new DateTime(23, 1, 1);
        new DateTime(0, 0, 0);
        new DateTime(23, 59, 59);*/
        new DateTime(-12, 12, 12); 	// отрицательный минуты не суще-ет
        new DateTime(23, 1, 60); 		// большое значение для секунды
        new DateTime(24, 0, 0); 		// большое значение для часа
        new DateTime(23, 60, 0); 		// большое значение для минуты
    }
}
