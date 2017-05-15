package exercises;

public class Main_1_2_3 {

    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            System.out.println(alg0(x) +" " + alg1(x) + " " +x);
        }
    }

    private static double alg0(Integer n) {
        return 100 * n * n;
    }


    private static double alg1(int n) {
        return 2 ^ n;
    }
}
