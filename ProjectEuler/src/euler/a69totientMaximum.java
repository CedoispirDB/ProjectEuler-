package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class a69totientMaximum {

    private static boolean compareMultiples(int a, int b) {
        boolean sameMultiples = false;
        boolean leave = false;
        for (int i = 1; i <= a; i++) {
            for (int k = 2; k <= b; k++) {
                if (a % i == 0 && b % k == 0 && i == k) {
                    sameMultiples = true;
                    leave = true;
                    break;
                }
            }
            if (leave) {
                break;
            }
        }
        return sameMultiples;
    }

    private static int totientFunction(int k) {
        int phi = 0;
        for (int i = 1; i <= k; i++) {
            if (!compareMultiples(i, k)) {
                phi++;
            }

        }
        return phi;
    }

    private static double findMax() {
        List<Double> nPhi = new LinkedList<>();
        double max = 0;
        double quotient;
        double check = 0;

        for (double n = 2; n <= 1000000; n++) {
            quotient = n / totientFunction((int) n);
            nPhi.add(quotient);
        }

        for (double k : nPhi) {
            if (k > check) {
                check = k;
                max = k;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // Im returning the max I need n fk
        tools.d(findMax());

    }
}

