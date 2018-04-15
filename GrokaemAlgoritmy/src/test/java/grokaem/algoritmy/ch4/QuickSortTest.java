package grokaem.algoritmy.ch4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuickSortTest {
    private QuickSort quickSort;

    @BeforeEach
    void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    void recursiveSum() {
        int[] array = IntStream.range(0, 20).toArray();
        int expected = IntStream.of(array).sum();
        int actual = quickSort.recursiveSum(array);
        assertEquals(expected, actual);
    }

    @Test
    void count() {
        List<Integer> list = IntStream.range(1, 55).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(list.size(), quickSort.count(list));
    }

    @Test
    void max() {
        List<Integer> numbers = new Random()
                .ints(2000)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        int expected = numbers.stream().max(Comparator.naturalOrder()).get();
        int actual = quickSort.max(numbers);
        assertEquals(expected, actual);
    }

    @Test
    void search() {
        int[] array = new Random().ints(10000).sorted().toArray();
        int toSearch = array[new Random().nextInt(array.length - 1)];
        assertEquals(toSearch, quickSort.search(array, toSearch).get().intValue());
    }

    @Test
    void sort() {
        int[] numbers = new Random()
                .ints(1000000)
                .toArray();
        int[] sorted = quickSort.sort(numbers);
        for (int i = 1; i < sorted.length; i++) {
            assertTrue(sorted[i -1] <= sorted[i]);
        }
    }

    @Test
    void quickSort() {
        List<Integer> numbers = new Random()
                .ints(1000000)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<Integer> sorted = quickSort.quickSort(numbers);
        for (int i = 1; i < sorted.size(); i++) {
            assertTrue(sorted.get(i - 1) <= sorted.get(i));
        }
    }
}