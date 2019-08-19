package telesens.academy.lesson9a;

public class GenArrayTest {
    public static void main(String[] args) {
        GenArray<Integer> integerGenArray = new GenArray<>(new Integer[5]);
        integerGenArray.set(0, 2);
        integerGenArray.set(1, 5);
        integerGenArray.set(6, 5);
        int element = integerGenArray.get(1);
        System.out.println(element);
        System.out.println(integerGenArray);

    }
}
