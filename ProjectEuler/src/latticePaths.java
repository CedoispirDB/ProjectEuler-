import java.math.BigInteger;

public class latticePaths {
    public static BigInteger findPossibilities(long n){
        long doubleOfN = 2 * n;
        BigInteger numerator = BigInteger.valueOf(tools.factorialOfNumber(doubleOfN));
        BigInteger factorialOfN = BigInteger.valueOf(tools.factorialOfNumber(n));
        BigInteger denominator = factorialOfN.pow(2);
        return numerator.divide(denominator);
    }

    public static void main(String[] args) {
       tools.d(findPossibilities(20));
    }
}
