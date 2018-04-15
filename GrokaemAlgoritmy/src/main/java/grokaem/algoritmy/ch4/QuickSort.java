package grokaem.algoritmy.ch4;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.IntStream;

public class QuickSort {
    private Random random = new Random();

    public int recursiveSum(int[] arrray) {
        if (arrray == null || arrray.length == 0) {
            return 0;
        }
        if (arrray.length == 1) {
            return arrray[0];
        } else {
            return arrray[0] + recursiveSum(Arrays.copyOfRange(arrray, 1, arrray.length));
        }
    }

    public int count(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        } else {
            return 1 + count(list.subList(1, list.size()));
        }
    }

    public int max(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw  new InvalidParameterException();
        }
        int first = numbers.get(0);
        if (numbers.size() == 1) {
            return first;
        } else {
            int max = max(numbers.subList(1, numbers.size()));
            return first > max ? first : max;
        }
    }

    public Optional<Integer> search(int[] array, int value) {
        int first = 0;
        int last = array.length - 1;

        if (first <= last) {
            int i = (first + last) / 2;
            int guess = array[i];
            if (guess == value) {
                return Optional.of(guess);
            }
            if (guess > value) {
                last = i - 1;
            } else {
                first = i + 1;
            }
            return search(Arrays.copyOfRange(array, first, last + 1), value);
        }

        return Optional.empty();
    }

    public int[] sort(int[] numbers) {
        if (numbers.length < 2) {
            return numbers;
        } if (numbers.length == 2) {
            if (numbers[1] > numbers[0]) {
                return numbers;
            } else {
                int x = numbers[0];
                numbers[0] = numbers[1];
                numbers[1] = x;
                return numbers;
            }
        } else {
            int[] less = Arrays.stream(numbers)
                    .skip(1)
                    .filter(x -> x <= numbers[0])
                    .toArray();
            int[] more = Arrays.stream(numbers)
                    .skip(1)
                    .filter(x -> x > numbers[0])
                    .toArray();
            int[] sortedLess = sort(less);
            int[] sortedMore = sort(more);
            int[] result  = IntStream
                    .concat(Arrays.stream(sortedLess),
                            IntStream.concat(IntStream.of(numbers[0]), Arrays.stream(sortedMore)))
                    .toArray();
            return result;
        }
    }

    public List<Integer> quickSort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        } else {
            int index = random.nextInt(numbers.size());
            List<Integer> less = new ArrayList<>();
            List<Integer> more = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                if (i != index) {
                    if (numbers.get(i) <= numbers.get(index)) {
                        less.add(numbers.get(i));
                    } else {
                        more.add(numbers.get(i));
                    }
                }
            }
            List<Integer> result = quickSort(less);
            result.add(numbers.get(index));
            result.addAll(quickSort(more));
            return result;
        }
    }
}
