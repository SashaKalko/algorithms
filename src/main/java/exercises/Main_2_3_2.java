package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_2_3_2 {

    public static void main(String[] args) {
        List<Integer> arr0 = Arrays.asList(1, 5, 7, 9, 9, 5, 4, 3, 2, 1, 10);
        System.out.println(sort(arr0));
    }

    private static List<Integer> merge(List<Integer> arr0, List<Integer> arr1) {
        List<Integer> ret = new ArrayList<>();
        int i0 = 0;
        int i1 = 0;
        for (int x = 0; x < arr0.size() + arr1.size(); x++) {
            if (i0 == arr0.size()) {
                ret.addAll(arr1.subList(i1, arr1.size()));
                break;
            } else if (i1 == arr1.size()) {
                ret.addAll(arr0.subList(i0, arr0.size()));
                break;
            } else {
                if (arr0.get(i0) <= arr1.get(i1)) {
                    ret.add(arr0.get(i0));
                    i0++;
                } else {
                    ret.add(arr1.get(i1));
                    i1++;
                }
            }
        }
        return ret;
    }

    private static List<Integer> sort(List<Integer> arr) {
        if (arr.size() >= 2) {
            int len0 = arr.size() / 2;
            return merge(sort(arr.subList(0, len0)), sort(arr.subList(len0, arr.size())));
        }
        return arr;
    }
}
