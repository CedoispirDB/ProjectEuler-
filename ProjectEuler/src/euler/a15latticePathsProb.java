package euler;
import utils.tools;

import java.math.BigInteger;

public class a15latticePathsProb {
    public static BigInteger findPossibilities(long n){
        long doubleOfN = 2 * n;
        BigInteger numerator = tools.factorialOfNumberB(doubleOfN);
        BigInteger factorialOfN = tools.factorialOfNumberB(n);
        BigInteger denominator = factorialOfN.pow(2);
        return numerator.divide(denominator);
    }

    public static void main(String[] args) {
       tools.d(findPossibilities(15));
    }
}
