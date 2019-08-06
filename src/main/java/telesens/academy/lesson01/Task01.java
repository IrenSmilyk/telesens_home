/*Предложить пользователю с консоли ввести данные об абоненте и вывести данные на экран, пример:
        > Введите Имя: Алексей
        > Введите Фамилию: Сидоров
        > Введите Отчество: Игорев
        > Введите Возраст: 45
        > Ввыберите Пол (м/ж): м
        > Введите Номер (10 цифр): 0991234567
        --------Абонент--------
        Имя: Алексей
        Фамилия: Сидоров
        Отчество: Игорев
        Возраст: 45
        Пол: м
        Номер: 0991234567*/
package telesens.academy.lesson01;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите Имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите Отчество: ");
        String patronymic = scanner.nextLine();
        System.out.print("Введите Возраст: ");
        int age = scanner.nextInt();
        System.out.print("Введите Пол (м/ж): ");
        String humanSex = scanner.next();
        System.out.print("Введите Номер (10 цифр): ");
        long phone = scanner.nextLong();
        System.out.println("--------Абонент--------");
        System.out.printf("Имя: %s%nФамилия: %s%nОтчество: %s%nВозраст: %d%nПол: %s%nНомер: %d%n",name,surname,patronymic,age,humanSex,phone);
    }
}
