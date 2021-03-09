package euler;

import utils.tools;
import utils.mathTools;
import java.math.BigInteger;

public class a33digitCancellingFractions {
    private static double removeLikeTherms(int n, int d) {
        double quotient;
        String nS = String.valueOf(n);
        String dS = String.valueOf(d);

        if (!dS.contains(nS.substring(0, 1)) && !dS.contains(nS.substring(1))) {
            return 1;
        }
//        tools.d("nS: " + nS);
//        tools.d("dS: " + dS);
        if (nS.charAt(0) == dS.charAt(0)) {
//            tools.d("--1--");
            n = Integer.parseInt(nS.substring(1));
            d = Integer.parseInt(dS.substring(1));
        } else if (nS.charAt(1) == dS.charAt(1)) {
//            tools.d("--2--");
            n = Integer.parseInt(nS.substring(0, 1));
            d = Integer.parseInt(dS.substring(0, 1));
        } else if (nS.charAt(0) == dS.charAt(1)) {
//            tools.d("--3--");
            n = Integer.parseInt(nS.substring(1));
            d = Integer.parseInt(dS.substring(0, 1));
        } else {
//            tools.d("--4--");
            n = Integer.parseInt(nS.substring(0, 1));
            d = Integer.parseInt(dS.substring(1));
        }

        quotient = (double) n / d;

        return quotient;
    }

    private static String productOfDenominators() {
        int nProduct = 1;
        int dProduct = 1;
        String finalProduct = "";
        double quotient;
        String nS;
        String dS;
        boolean pass;
        for (int n = 10; n <= 99; n++) {
            for (int d = 10; d <= 99; d++) {
                nS = String.valueOf(n);
                dS = String.valueOf(d);

                quotient = (double) n / d;

                pass = nS.charAt(0) != nS.charAt(1) && dS.charAt(0) != dS.charAt(1) && !(quotient >= 1) && !nS.contains("0") && !dS.contains("0");
                if (quotient == removeLikeTherms(n, d) && pass) {
                    nProduct *= n;
                    dProduct *= d;
                }

            }
        }
        return mathTools.simplifyNum2(nProduct, dProduct);
    }


    public static void main(String[] args) {
        tools.d(productOfDenominators());
//        tools.d(removeLikeTherms(48,98));
    }
}
