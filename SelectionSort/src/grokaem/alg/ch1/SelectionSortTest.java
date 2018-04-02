package grokaem.alg.ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @org.junit.jupiter.api.Test
    void selectionSort() {
        List<Integer> list = new Random()
                .ints(2000)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<Integer> newList = new SelectionSort().selectionSort(list);
        for (int i = 1; i < list.size(); i++) {
            assertTrue(newList.get(i - 1) <= newList.get(i));
        }
    }
}