package grokaem.algoritmy.ch5;

import java.util.stream.Stream;

public class SimpleHashTable<T> {

    private T[] values;

    private final double LOAD_FACTOR = 0.7;

    public SimpleHashTable() {
        values = (T[]) new Object[16];
    }

    public void put(T value) {
        long count = Stream.of(values)
                .filter(x -> x != null)
                .count();
        if ((double)(count + 1) / values.length > 0.7) {
            resize();
        }
        values[hash(value)] = value;
    }

    public T get(T key) {
        return values[hash(key)];
    }

    private int hash(T value) {
        return value.hashCode() % values.length;
    }

    private void resize() {
        T[] newValues = (T[]) new Object[values.length * 2];
        for (T value : values) {
            newValues[value.hashCode() % (values.length * 2)] = value;
        }
        values = newValues;
    }
}
