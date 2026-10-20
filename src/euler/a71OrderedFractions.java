package euler;

import java.util.LinkedList;
import utils.*;

public class a71OrderedFractions {

    private static final LinkedList<Integer> check_stack = new LinkedList<>();

    private static void load_stack(double max) {
        for (int i = 1; i < max; i++) {
            check_stack.add(35 * i);
        }
    }

    private static double solution(double max) {
        double max_r = 0.0;
        double max_n = 0.0;

        for (double d = 2; d <= max; d++) {
            for (double n = 1; n < d; n++) {

                Log.printfln("Processing: d= %f, n= %f", d, n);

                double middle = 35 * n;
                double lower = 14 * d;
                double upper = lower + d;
                if (!(lower < middle && middle < upper)) {
                    continue;
                }

                if (MaT.gcd(d, n) != 1) {
                    continue;
                }

                double r = n / d;

                Log.printfln("Trying: r: %f, max_r: %f for max_n: %f", r, max_r, max_n);

                if (r > max_r) {
                    max_r = r;
                    max_n = n;
                }
            }
        }

        return max_n;

    }

    private static void testing(int max) {

        double max_r = 0.0;
        double max_n = 0.0;

        for (int d = 2; d <= max; d++) {
            // Log.println("d: " + d);
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

                // Log.printfln("(%d) -> %d < %d < %d (%B) | %f", n, l, m, u, check, r);
                // Log.printfln("(%d) -> %d < %d (%B)", n, l, m, lower_check);
                // Log.printfln("(%d) -> %d < %d (%B)", n, m, u, upper_check);
            }

            // Log.skip_line();
        }

        Log.println(max_n);
    }

    public static void main(String[] args) {
        double max = Const.ONE_MILLION;
        // Log.println("Solution: " + solution(Const.ONE_MILLION));
        // testing(Const.ONE_MILLION);
        testing((int) max);
        // load_stack(max);
        // Log.list(check_stack);
    }

}
