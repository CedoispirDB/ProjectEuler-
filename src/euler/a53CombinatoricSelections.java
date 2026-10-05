package euler;

import utils.tools;

import java.math.BigInteger;


public class a53CombinatoricSelections {

    private static int findCombinatronics(int n, int r) {
        int count;
        BigInteger x;
        x = tools.factorialOfNumberB(n).divide(tools.factorialOfNumberB(r).multiply(tools.factorialOfNumberB((n - r))));

        if (x.compareTo(BigInteger.valueOf(1000000)) > 0) {
            return 1000001;
        }

        count = Integer.parseInt(String.valueOf(x));
        return count;
    }

    private static void index() {
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                tools.d("n: " +  n);
                tools.d("r: " +  r);
                tools.d("Combinations: " + findCombinatronics(n ,r));
                if (findCombinatronics(n, r) > 1000000) {
                    count++;
                }
            }

        }
        tools.d(count);
    }

    public static void main(String[] args) {
        index();
    }

}
