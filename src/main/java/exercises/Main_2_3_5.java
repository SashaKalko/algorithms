package exercises;

import java.util.Arrays;
import java.util.List;

public class Main_2_3_5 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 10);
        search(integers, 10);
    }

    private static int search(List<Integer> arr, int el) {
        return search(arr, 0, arr.size() - 1, el);
    }

    private static int search(List<Integer> arr, int start, int end, int el) {
        int middle = start + (end - start) / 2;
        if (end - start < 2) {
            return arr.get(start).equals(el) ? start : arr.get(end).equals(el) ? end : -1;
        } else if (arr.get(middle).equals(el))
            return middle;
        else if (el < arr.get(middle)) {
            return search(arr, start, middle - 1, el);
        } else
            return search(arr, middle + 1, end, el);
    }
}
