package euler;

import utils.tools;

import java.math.BigInteger;

public class a56powerfulDigitSum {

    private static int digSum(String nStr) {
        int sum = 0;
        for (int i = 0; i < nStr.length(); i++) {
            sum += Integer.parseInt(String.valueOf(nStr.charAt(i)));
        }
        return sum;
    }

    private static long maxDigSum() {
        long totalDigSum;
        long tempValue = 0;

        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                BigInteger aB = BigInteger.valueOf(a);
                totalDigSum = digSum(String.valueOf(aB.pow(b)));
                if (totalDigSum > tempValue){
                    tempValue = totalDigSum;
                }
            }
        }

        return tempValue;
    }


    public static void main(String[] args) {
        tools.d(maxDigSum());
    }
}
