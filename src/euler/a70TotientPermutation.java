package euler;

import utils.*;

public class a70TotientPermutation {

    // O(sqrt(n))
    private static long eulerProduct(long n) {
        if (n < 0) {
            return -1;
        }

        long r = n;

        for (long p = 2; p <= n / p; p++) {
            if (n % p == 0) {
                r = r - r / p;

                while (n % p == 0) {
                    n = n / p;
                }
            }
        }

        if (n > 1) {
            r = r - r / n;
        }

        return r;
    }

    private static int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Tools.charToDigit(str.charAt(i));
        }

        return sum;
    }

    private static boolean isPermutation(int a, int b) {
        String a_str = String.valueOf(a);
        String b_str = String.valueOf(b);

        if (a_str.length() != b_str.length()) {
            return false;
        }

        if (sumDigits(a_str) != sumDigits(b_str)) {
            return false;
        }

        int[] frequency = new int[10];

        for (int i = 0; i < a_str.length(); i++) {
            frequency[a_str.charAt(i) - '0']++;
            frequency[b_str.charAt(i) - '0']--;
        }

        for (int c : frequency) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    private static void MySolution() {
        double min_ratio = Double.MAX_VALUE;
        long final_n = 0;
        long max = 10000000;

        for (long n = 2; n < max; n++) {
            Log.printfln("Trying: %d", n);
            long t = eulerProduct(n);

            double r = (double) n / (double) t;

            if (r > min_ratio) {
                continue;
            }

            if (!isPermutation((int) t, (int) n)) {
                continue;
            }

            min_ratio = r;
            final_n = n;

            Log.printfln("%d -> %d", n, t);
        }
        Log.printfln("min_ratio: %f, final_n: %d", min_ratio, final_n);

    }

    // optimization - https://projecteuler.net/thread=70#240
    private static void EulerSolution() {
        int max = 10000000;

        int a = 1;
        int b = 2;

        double min_r = 2;
        int min_n = 2;

        int pa = PrimeT.prime(a);
        int pb = PrimeT.prime(b);

        while ((long) pa * pb < max) {
            int n = pa * pb;
            int c = (pa - 1) * (pb - 1);

            if (isPermutation(n, c)) {
                double r = (double) n / c;

                if (r < min_r) {
                    min_r = r;
                    min_n = n;
                }
            }

            b += 1;
            pb = PrimeT.prime(b);

            if ((long) pa * pb >= max) {
                a++;
                b = a + 1;

                pa = PrimeT.prime(a);
                pb = PrimeT.prime(b);
            }
        }

        Log.println("Solution: " + min_n);

    }

    public static void main(String[] args) {
        EulerSolution();
    }
}
