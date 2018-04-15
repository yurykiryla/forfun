package grokaem.algoritmy.ch2;

import java.util.LinkedList;
import java.util.List;

public class SelectionSort {

    private int smallestElementIndex(List<Integer> list) {
        var smallest = list.get(0);
        var smallest_index = 0;
        for (var i = 1; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallest_index = i;
            }
        }
        return smallest_index;
    }

    public List<Integer> selectionSort(List<Integer> list) {
        List<Integer> newList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            int smallest = smallestElementIndex(list);
            newList.add(list.remove(smallest));
        }
        return newList;
    }
}
