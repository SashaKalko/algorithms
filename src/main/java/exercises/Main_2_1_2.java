package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main_2_1_2 {

    public static void main(String[] args) {
        System.out.println(sort(Arrays.asList(9, 8, 7, 6, 5)));
    }

    private static List<Integer> sort(List<Integer> arr) {
        for (int x = 1; x < arr.size(); x++) {
            Integer key = arr.get(x);
            int j = x - 1;
            while (j > -1 && arr.get(j) < key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
        return arr;
    }
}
