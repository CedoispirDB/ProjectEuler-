package euler;

import utils.*;

public class a69TotientMaximum {

    private static double calculateMax(int max) {
        double max_r = 0;
        long max_n = 0;

        for(long n = 2; n <= max; n++) {
            long t = Mat.eulerProduct(n);

            double ratio = (double) n / (double) t;

            if(ratio > max_r) {
                max_n = n;
                max_r = ratio;
            }

            Log.printfln("n: %d -> phi(n): %d -> n/phi(n): %f", n, t, ratio);
        }

        return max_n;
    }

    public static void main(String[] args) {
        Log.println("Solution: " + calculateMax(1000000));
    }
}
