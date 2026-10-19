package euler;

import utils.*;

public class a71OrderedFractions {

    private static double solution(double max) {
        double max_r = 0.0;
        double max_n = 0.0;

        double lower_bound_n = (2.0 / 5.0) * 1;
        double upper_bound_n = (3.0 / 7.0) * max;

        double lower_bound_d = (7.0 / 3.0);
        double upper_bound_d = (5.0 / 2.0);

        for (double n = Math.ceil(lower_bound_n); n < Math.floor(upper_bound_n); n++) {
            for (double d = Math.ceil(lower_bound_d * n); d < Math.floor(upper_bound_d * n); d++) {
                if(d == 0) continue;
                if (MaT.gcd(n, d) != 1) {
                    continue;
                }
                Log.printfln("Doing: %f / %f = %f", n, d, n / d);

                double r = n / d;
                if (r > max_r) {
                    max_r = r;
                    max_n = n;
                }
            }
        }

        return max_n;

    }

    public static void main(String[] args) {
        Log.println("Solution: " + solution(Const.ONE_MILLION));
    }

}
