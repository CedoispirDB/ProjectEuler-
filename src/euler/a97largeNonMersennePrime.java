package euler;

import java.math.BigInteger;

import utils.tools;

public class a97largeNonMersennePrime {

    private static String bigPrimeLastDigits(){
        BigInteger x = BigInteger.valueOf(2);
        BigInteger y = BigInteger.valueOf(28433);
        String r = String.valueOf(y.multiply(x.pow(7830457)).add(BigInteger.valueOf(1)));
        return r.substring(r.length() - 10);
    }


    public static void main(String[] args) {
        tools.d(bigPrimeLastDigits());
    }
}
