import java.math.BigInteger;

public class latticePaths {
    public static BigInteger findPossibilities(long n){
        long doubleOfN = 2 * n;
       // tools.d("Double of n: " + doubleOfN);

        BigInteger numerator = tools.factorialOfNumberB(doubleOfN);
       // tools.d("Numerator: " + numerator);

        BigInteger factorialOfN = tools.factorialOfNumberB(n);
       // tools.d("Factorial of n: " + factorialOfN);

        BigInteger denominator = factorialOfN.pow(2);
       // tools.d("Denominator: " + denominator);

        BigInteger division = numerator.divide(denominator);
        tools.d("Division: " + division);

        return division;
    }

    public static void main(String[] args) {
       findPossibilities(20);
    }
}
