package euler;

import utils.tools;

public class a719numberSplitting {

    private static boolean splitNum(long x) {
        String xS = String.valueOf(x);
        int sum = 0;

        for (int i = 0; i < xS.length(); i++) {
            sum += Integer.parseInt(xS.substring(i, i + 1));
        }
//        tools.d("sum: " + sum);

        if (sum == x) {
            return true;
        }

        tools.i("");


        for (int i = 0; i < xS.length(); i++) {
            if (!xS.substring(0, i).isEmpty()) {
                sum = (Integer.parseInt(xS.substring(0, i)) + Integer.parseInt(xS.substring(i)));
                tools.d(xS.substring(0, i));
                tools.d(xS.substring(i));
                tools.d("sum: " + sum);
                if (sum == x) {
                    return true;
                }

            }
        }

        return false;
    }

    private static int splitSum(long n) {

        long x;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            x = (long) Math.sqrt(i);
            if (splitNum(x)) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
//        splitSum(1000000000000L);
//        tools.d(splitSum(10000));
//        splitNum(8281);
        String x = "9801";
        StringBuilder newX = new StringBuilder();
        int sum;
        int d = 0;
        int k = 0;

        for (int i = 0; i < x.length(); i++) {
            newX.append(x.charAt(i));
            if (i > 0) {
                k = Integer.parseInt(String.valueOf(x.charAt(i - 1)));
            }
            int i1 = Integer.parseInt(String.valueOf(x.charAt(i)));
            for (int j = d; j < x.length(); j++) {
                if (!x.substring(j + 1).isEmpty()) {
                    sum = k + i1 + Integer.parseInt(x.substring(j + 1));
                    tools.d(k + " + " + i1 + " + " + x.substring(j + 1) + " = " + sum);

                }
            }
            d++;

            tools.i();
        }


        //  9 8 0 1
        //  98 01
        //  980 1
        //  9 801
//
//        for (int i = 0; i < x.length(); i++) {
////            tools.d(x.substring(i, i + 1));
//        }
////        tools.i("");
//        for (int i = 0; i < x.length() / 2; i++) {
////            tools.d(x.substring(i, i + 2));
//        }
////        tools.d(x.substring(0, 2));
////        tools.d(x.substring(2));
//
////
////        for (int i = 0; i < x.length(); i++) {
////            tools.d(x.substring(0, i));
////            tools.d(x.substring(i));
////            tools.i("");
////        }
    }

}
//1000000000000