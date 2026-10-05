package euler;
import utils.tools;

import java.math.BigInteger;

public class a48selfPowers {

    private static String powers(){
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000 ; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        String sumStr = String.valueOf(sum);
        return sumStr.substring(sumStr.length() - 10);
    }

    public static void main(String[] args) {
        tools.d(powers());
    }
}
