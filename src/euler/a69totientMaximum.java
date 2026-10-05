package euler;

import utils.tools;

public class a69totientMaximum {

    private static boolean compareMultiples(int a, int b) {
        if (Math.max(a, b) % Math.min(a, b) == 0) {
            return true;
        }

        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }

    private static int totientFunction(int k) {
        int phi = 0;
        if (k == 1) {
            return 1;
        }
        if (tools.isItPrime(k)) {
            return k - 1;
        }
        for (int i = 1; i <= k; i++) {
            if (i % 100000 == 0) {
                tools.d("I'm at: " + i);
            }
            if (i == 1) {
                phi++;
            }
            if (!compareMultiples(i, k)) {
                phi++;
            }
        }
        return phi;
    }

    private static double findMax() {
        double nMax = 0;
        double quotient;
        double check = 0;
        for (double n = 2; n <= 1000000; n++) {
            if (n % 100000 == 0) {
                tools.d("I'm at: " + n);
            }
            quotient = n / totientFunction((int) n);
            if (quotient > check) {
                check = quotient;
                nMax = n;
                tools.d("nMax so far: " + nMax + " for: " + quotient + "\n");
            }
        }
        return nMax;
    }

    public static void main(String[] args) {
        tools.d(findMax());
    }
}

// 23 min first test with wrong number :/
// 972637 0.05 miliseconds because is prime
// 972638 17 minutes

//