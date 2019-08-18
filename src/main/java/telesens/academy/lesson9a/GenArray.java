package telesens.academy.lesson9a;

import java.util.Arrays;

public class GenArray <T> {
    private T[] array;

    GenArray(T[] array) {
        this.array = array;
    }

    T get(int index) {
        if (index>array.length)
            throw new IndexOutOfBoundsException();
        else return array[index];
    }

    void set(int index, T element) {
        if (index>array.length)
            throw new IndexOutOfBoundsException();
        else array[index] = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenArray<?> genArray = (GenArray<?>) o;
        return Arrays.equals(array, genArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "GenArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
