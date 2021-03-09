package euler;

import utils.tools;

import java.math.BigInteger;

public class a55LychrelNumbers {

    private static String rotateNum(String sequence, String x) {
        String newString = String.valueOf(sequence.charAt(sequence.length() - 1));
        String rest = sequence.substring(0, sequence.length() - 1);
        x = x + newString;
        if (rest.equals("")) {
            return x;

        }

        return rotateNum(rest, x);
    }

    private static boolean checkifIsLychrel(int a) {
        boolean ans = true;
        int limit = 50;
        BigInteger sum;
        int count = 0;
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger reverseBigA;
        BigInteger reverseBigSum;

        do {
            count++;

            reverseBigA = new BigInteger(rotateNum(String.valueOf(bigA), ""));
            sum = bigA.add(reverseBigA);

            reverseBigSum = new BigInteger(rotateNum(String.valueOf(sum), ""));
            if (sum.equals(reverseBigSum)) {
                return false;
            }

            bigA = sum;

        } while (count < limit);

        return ans;
    }

    private static int countLychrelNumbers() {
        int ans = 0;
        for (int i = 0; i < 10000; i++) {
            if (checkifIsLychrel(i)) {
                tools.d("lychrel: " + i);
                ans++;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        tools.d(countLychrelNumbers());
    }
}
