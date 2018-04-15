package grokaem.algoritmy.ch1;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @org.junit.jupiter.api.Test
    void search() {
        int[] array = new Random().ints(10000).sorted().toArray();
        Integer toSearch = array[new Random().nextInt(array.length - 1)];
        assertEquals(toSearch, new BinarySearch().search(array, toSearch).get());
    }
}