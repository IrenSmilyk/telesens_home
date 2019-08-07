/*Реализовать класс Abonent, который имеет поля:
        long id; // необязательное поле, по умолчанию -1
        String firstName;
        String lastName;
        int age;
        char gender; // 'm' - male, 'f' - female

        Все поля должны быть помечены модификатором private
		- реализовать доступ к полям через методы set и get
                - реализовать возможность создания класса через два конструктора:
                1-> все поля, без обязательного поля "id"
                2-> полный конструктор со всем полями

                - реализовать метод void print(); вывода информации абонента в отформатированном виде
                - реализовать метод boolean isEqualsById(Abonent abonent); // вернут true, если id обоих объектов равны и не равны -1, false - в остальных случаях
                - протестировать метод isEquals*/
package telesens.academy.lesson04;

public class Abonent {
    private long id = -1;
    private String firstName;
    private String lastName;
    private int age;
    private char gender; // 'm' - male, 'f' - female

    public Abonent(String firstName, String lastName, int age, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Abonent(long id, String firstName, String lastName, int age, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    public void print() {
        System.out.println("lesson04.academy.Abonent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}');
    }

    boolean isEqualsById(Abonent abonent) {
        return (this.id == abonent.id && this.id != -1);
    }
}
