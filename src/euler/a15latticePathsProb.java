package euler;
import utils.Tools;

import java.math.BigInteger;

public class a15latticePathsProb {
    public static BigInteger findPossibilities(long n){
        long doubleOfN = 2 * n;
        BigInteger numerator = Tools.factorialOfNumberB(doubleOfN);
        BigInteger factorialOfN = Tools.factorialOfNumberB(n);
        BigInteger denominator = factorialOfN.pow(2);
        return numerator.divide(denominator);
    }

    public static void main(String[] args) {
       Tools.d(findPossibilities(15));
    }
}
