package euler;

import utils.tools;

import java.math.BigInteger;

public class a63powerfulDigitCounts {

    private static int powDigCount(){
        int count = 0;
        BigInteger pow;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                BigInteger x = BigInteger.valueOf(i);
                pow = x.pow(j);
                if (String.valueOf(pow).length() == j){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        tools.d(powDigCount());
    }

}
