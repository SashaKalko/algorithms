package exercises;

import java.util.Arrays;
import java.util.List;

public class Main_2_2_2 {

    public static void main(String[] args) {
        System.out.println(sort(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
    }

    private static List<Integer> sort(List<Integer> arr) {
        for (int x = 0; x < arr.size() - 1; x++) {
            int smallestIndex = x;
            for (int j = x + 1; j < arr.size(); j++) {
                if (arr.get(smallestIndex) > arr.get(j)) {
                    smallestIndex = j;
                }
            }
            Integer el0 = arr.get(x);
            arr.set(x, arr.get(smallestIndex));
            arr.set(smallestIndex, el0);
        }
        return arr;
    }
}
