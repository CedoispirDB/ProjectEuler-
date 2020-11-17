package utils;

import java.util.LinkedList;
import java.util.List;

public class Tests {


    private static List<Integer> divFraction(double n1, double d1, double n2, double d2) {
        double n = n1 * d2;
        double d = d1 * n2;
        return mathTools.simplifyNum((int) n, (int) d);
    }

    private static List<Integer> sumFractions(double n1, double d1, double n2, double d2) {
        List<Integer> fraction = new LinkedList<>();
        double cf = mathTools.leastCommonDenominator(d1, d2);
        double result;
        n1 = n1 * (cf / d1);
        n2 = n2 * (cf / d2);
        result = n1 + n2;

        if (result % cf == 0) {
            fraction.add((int) (result / cf));
            fraction.add(1);
            return fraction;
        }
        return mathTools.simplifyNum((int) result, (int) cf);
    }

    private static List<Integer> expansion(int n, int d, int pos, int count) {

        if (pos == 0) {
            return sumFractions(1, 1, 1, 2);
        }
        if (count >= pos) {
            return sumFractions(1, 1, n, d);
        }
        List<Integer> sumFrac = sumFractions(2, 1, n, d);
        n = sumFrac.get(0);
        d = sumFrac.get(1);

        List<Integer> divFrac = divFraction(1, 1, n, d);

        n = divFrac.get(0);
        d = divFrac.get(1);
        count++;
        return expansion(n, d, pos, count);
    }

    private static int weirdExpansion() {
        int count = 0;
        int n;
        int d;

        for (int i = 0; i < 1000; i++) {
            List<Integer> k =  expansion(1, 2, i,   0);
            if (k.toArray().length != 1) {
                n = k.get(0);
                d = k.get(1);
                if (String.valueOf(n).length() > String.valueOf(d).length()) {
                    count++;
                    tools.d(count + " expansion: " + k);

                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        tools.d(weirdExpansion());

    }

}