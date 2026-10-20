package euler;

import utils.*;

public class a71OrderedFractions {

    private static double solution(double max) {
        double max_r = 0.0;
        double max_n = 0.0;

        for (double d = 2; d <= max; d++) {
            for (double n = 1; n < d; n++) {
                if ((d > 2 && n > 2) && (d % 2 == 0 && n % 2 == 0)) {
                    continue;
                }
                Log.printfln("Processing: d= %f, n= %f", d, n);

                double middle = 35 * n;
                double lower = 14 * d;
                double upper = lower + d;
                if (!(lower < middle && middle < upper)) {
                    continue;
                }

                if(MaT.gcd(d, n) != 1) {
                    continue;
                }

                double r = n / d;

                Log.printfln("Trying: r: %f, max_r: %f for max_n: %f", r, max_r, max_n);

                if(r > max_r) {
                    max_r = r;
                    max_n  =n;
                }
            }
        }

        return max_n;

    }

    public static void main(String[] args) {
        Log.println("Solution: " + solution(Const.ONE_MILLION));
    }

}
