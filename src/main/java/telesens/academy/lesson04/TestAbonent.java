package telesens.academy.lesson04;

public class TestAbonent {

    public static void main(String[] args) {
        Abonent firstAbonent = new Abonent(1, "Ira", "Smith", 31, 'f');
        Abonent secondAbonent = new Abonent(1, "Ira", "Smilyk", 32, 'f');
        firstAbonent.print();
        secondAbonent.print();
        printResult(firstAbonent, secondAbonent);
    }

    private static void printResult(Abonent first, Abonent second) {
        if (first.isEqualsById(second))
            System.out.println("Значение поля \'id\' объектов равны.");
        else
            System.out.println("Значение поля \'id\' объектов не равны.");
    }
}
