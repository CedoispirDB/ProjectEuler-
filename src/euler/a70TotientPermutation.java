package euler;

import utils.*;

public class a70TotientPermutation {

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int totient(int max) {
        int sum = 0;

        for (int i = 1; i <= max; i++) {
            if (gcd(max, i) == 1) {
                sum++;
            }
        }

        return sum;
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

    public static void main(String[] args) {

        double min_ratio = 1;
        int final_n = 0;
        int max = 10000000;

        for (int n = 87109; n < 87109 + 1; n++) {
            Log.printfln("Trying: %d", n);
            int t = totient(n);

            if (t > n) {
                continue;
            }

            double r = (double) n / (double) t;

            Log.println(r);

            // if (r > min_ratio) {
            //     continue;
            // }

            if (!isPermutation(t, n)) {
                continue;
            }

            min_ratio = r;
            final_n = n;
            Log.printfln("%d -> %d", n, totient(n));

            // for(int j = 1; j <= i; j++) {
            //     Log.printfln("gdc(%d, %d) = %d", i, j, gcd(i, j));
            // }
        }

        Log.printfln("min_ratio: %f, final_n: %d", min_ratio, final_n);
    }
}
