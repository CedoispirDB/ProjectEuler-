package euler;

import java.math.BigInteger;

import utils.tools;

public class a686powersOfTwo {

//    2 ^ x = 123...
//    678910 time it happens

    //  digits in the answer 3 or 4 to give x digits
//  x ^ 300 , 75
//  2 ^ n = (nlog102) + 1
    private static int twoToThePower(int limit) {
        BigInteger result = BigInteger.valueOf(1);
        BigInteger oneTwoThree = BigInteger.valueOf(123);
        BigInteger ten = BigInteger.valueOf(10);
        BigInteger sixOne = BigInteger.valueOf(610);
        BigInteger Three = BigInteger.valueOf(300);
        BigInteger tenPow;

        int count = 0;
        int x = 0;
        int n;
        int k = 1;

        do {
            x++;
            result = result.multiply(BigInteger.valueOf((long) Math.pow(2, k)));
            k = 1;
            n = (int) (x * 0.301029995663981) + 1;
            n = n - 3;
//            if (x == 90) {
//                tools.d("n : " + n + " || x: " + x);
//                tools.d("Result length: " + result.toString().length());
//                tools.d("Result: " + result);
//                tools.d(oneTwoThree.multiply(ten.pow(n)));
//                tools.d((oneTwoThree.add(BigInteger.valueOf(1)).multiply(ten.pow(n)).subtract(BigInteger.ONE)));
//            }
            if (n > 0) {
                tenPow = ten.pow(n);
                if (oneTwoThree.multiply(tenPow).compareTo(result) < 0 && (oneTwoThree.add(BigInteger.ONE).multiply(tenPow).subtract(BigInteger.ONE)).compareTo(result) > 0) {
                    count++;
//                    tools.d(count + " || " + x + ", " + result .divide(BigInteger.valueOf(4)));
                    tools.d(count + " || " + x);

                } else if (sixOne.multiply(tenPow).compareTo(result) < 0 && (sixOne.add(BigInteger.ONE).multiply(tenPow).subtract(BigInteger.ONE)).compareTo(result) > 0) {
                    k = 2;
                } else if (Three.multiply(tenPow).compareTo(result) < 0 && (Three.add(BigInteger.ONE).multiply(tenPow).subtract(BigInteger.ONE)).compareTo(result) > 0) {
                    k = 3;
                }
            }
        } while (count < limit);
        return x;
    }

    public static void main(String[] args) {
        tools.d(twoToThePower(678910));
    }

}

//2020-12-24 13:23:29.386 : 1 || 90
//2020-12-24 13:23:53.521 : 398 || 113195
//24.2 seconds

//2020-12-24 13:24:48.524 : 1 || 90
//2020-12-24 13:25:13.132 : 398 || 113195
//25 seconds
