package exercises;

public class Main_1_2_2 {

    public static void main(String[] args) {
        for (int x = 0; x < 100; x++) {
            System.out.println("merge sort: " + mergeSort(x) +", insertion sort: " + insertionSort(x)+", n: " + x);
        }
    }

    private static double mergeSort(Integer n) {
        return 64 * n * Math.log10(n.doubleValue());
    }


    private static double insertionSort(int n) {
        return 8 * n * n;
    }
}
