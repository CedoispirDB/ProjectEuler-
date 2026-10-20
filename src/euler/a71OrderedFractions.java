package euler;

import utils.*;

public class a71OrderedFractions {

    private static double solution(int max) {

        double max_r = 0.0;
        double max_n = 0.0;

        for (int d = 2; d <= max; d++) {
            int l = 14 * d;
            int u = 15 * d;

            int n_start = (int) Math.ceil(l / 35) + 1;

            for (int n = n_start; n < d; n++) {
                if ((d > 2 && n > 2) && (d % 2 == 0 && n % 2 == 0)) {
                    continue;
                }
                int m = 35 * n;
                boolean lower_check = l < m; // if true for m1 then is true for all m >= m1
                boolean upper_check = m < u; // if false for m2 then is false for all m >= m2

                boolean check = (lower_check) && (upper_check);
                if (!upper_check) {
                    break;
                }

                double r = (double) n / d;

                if (r > max_r) {
                    max_r = r;
                    max_n = n;
                }
            }
        }

        return max_n;
    }

    public static void main(String[] args) {
        double max = Const.ONE_MILLION;
        Log.println("Solution: " + solution(Const.ONE_MILLION));
    }
}
