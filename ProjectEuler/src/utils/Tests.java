package utils;

import java.math.BigInteger;

public class Tests {

//    public static void main(String[] args) {
//        int count = 0;
//        BigInteger result = BigInteger.valueOf(1);
//        int k = 0;
//
//        do {
//            k++;
//            result = result.multiply(BigInteger.valueOf(2));
//
//            if (result.toString().startsWith("123")) {
//                count++;
//                tools.d(count + " || " + k);
//            }
//
//        } while (count != 678910);
//    }

    private static void test() {
        int n = 0;
        int consecutive = 0;
        int numberOfFactors = 4;
        do {
            n++;
                if (mathTools.primeFactors(n) >= numberOfFactors) {
                    consecutive++;
//                tools.d(n);
                } else {
                    consecutive = 0;
                }

            if (n % 1000 == 0){
                tools.d(n);
            }

        } while (consecutive < numberOfFactors);
        tools.d(n - numberOfFactors + 1);
    }

    public static void main(String[] args) {
        test();
    }
}

