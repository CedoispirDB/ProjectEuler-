package euler;

import utils.tools;
import utils.mathTools;

import java.util.LinkedList;
import java.util.List;

public class a57squareRootConvergents {

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

//    private static List<Integer> expansion(int n, int d, int pos, int count) {
//
//        if (pos == 0) {
//            return sumFractions(1, 1, 1, 2);
//        }
//        if (count >= pos) {
//            return sumFractions(1, 1, n, d);
//        }
//
//        count++;
//        return expansion(n, d, pos, count);
//    }

    private static int weirdExpansion() {
        int count = 0;
        int n = 1;
        int d = 2;
        int n2;
        int d2;
        int i = 0;
        do {
//            List<Integer> k = expansion(n, d, i, i);

            if (i == 0) {
                tools.d((i + 2) + ": " + "1 + " + n + "/" + d + " " + sumFractions(1, 1, n, d));
            }

            List<Integer> sumFrac = sumFractions(2, 1, n, d);
            n = sumFrac.get(0);
            d = sumFrac.get(1);

            n2 = n;
            n = d;
            d = n2;

            tools.d((i + 2) + ": " + "1 + " + n + "/" + d + " " + sumFractions(1, 1, n, d));

            String x = String.valueOf(sumFractions(1, 1, n, d).get(0));
            String y = String.valueOf(sumFractions(1, 1, n, d).get(1));

            if (x.length() > y.length() && x.length() != 2 && y.length() != 1) {
                tools.i("");
                tools.d("n: "+ sumFractions(1, 1, n, d).get(0));
                tools.d("d: " + sumFractions(1, 1, n, d).get(1) + "\n");


                count++;
            }

//            n2 = k.get(0);
//            d2 = k.get(1);


//            if (String.valueOf(n2).length() > String.valueOf(d2).length()) {
//                count++;
//            } else {
//                tools.d((i+1 )+ " expansion: " + k);
//            }

            i++;
        } while (i <= 1000);
        return count;
    }

    public static void main(String[] args) {
        tools.d(weirdExpansion());

    }

}
// 25: 2147483647 /  2147483647 = 1
// 26: 2 / 1
// 27:

// first answer: 191

//2020-11-18 10:42:10.462 : 859: 1 + 3/1 [4, 3]