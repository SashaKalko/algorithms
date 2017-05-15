package exercises;

import java.util.Arrays;
import java.util.List;

public class Main_2_1_3 {

    public static void main(String[] args) {
        System.out.println(find(Arrays.asList(9, 8, 7, 6, 5), 10));
    }

    private static Integer find(List<Integer> arr, int n) {
        for (Integer x : arr) {
            if (x.equals(n)) return x;
        }
        return null;
    }
}
