import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class tools {

    //Formatting a number
    public static void format(double in) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println(decimalFormat.format(in));
    }

    //Print value with date and time
    public static void d(Object x, int line) {
        if (line == 0) {
            System.out.print(new Timestamp(System.currentTimeMillis()) + " : " + x + " ");
        } else {
            System.out.println(new Timestamp(System.currentTimeMillis()) + " : " + x);
        }
    }

    //Print value in the same line line
    public static void d(Object x) {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " : " + x);
    }

    //Print value without date
    public static void l(Object x) {
        System.out.println(x);
    }

    //Find if a number is prime or not
    public static boolean isItPrime(long x) {
        long sumOfDivisors = 0;
        for (long i = 1; i < x; i++) {
            if (x % i == 0) {
                sumOfDivisors += i;
                if (sumOfDivisors > 1) {
                    return false;
                }
            }
        }


        return sumOfDivisors == 1;
    }

    //Find the factorial of a number - returns A BigInteger
    public static BigInteger factorialOfNumberB(long n) {
        BigInteger factorial = BigInteger.valueOf(1);
        int x = Integer.parseInt(String.valueOf(n));
        for (long i = 1; i <= x; i++) {
            BigInteger ib = BigInteger.valueOf(i);
            factorial = factorial.multiply(ib);
            //tools.d(factorial);
        }
        //tools.d("y: " + factorial);
        return factorial;

    }

    //Find the factorial of a number - returns a long
    public static long factorialOfNumber(long n) {
        long factorial = 1;
        for (long i = 1; i <= n; i++) {
            factorial = factorial * i;
            //tools.d(factorial);
        }
        //tools.d("y: " + factorial);
        return factorial;

    }

    //Find the sum of all the divisors of a number
    public static long sumOfDivisors(long x) {
        long sumOfDivisors = 0;
        for (long i = 1; i < x; i++) {
            if (x % i == 0) {
                sumOfDivisors += i;
            }
        }
        return sumOfDivisors;
    }

    //Give the result of a number x to the e power
    public static int exponent(int x, int e) {
        double result = Math.pow(x, e);
        return (int) result;
    }

    public static long exponent(long x, long e) {
        double result = Math.pow(x, e);
        return (long) result;
    }



    //tools.d(primeNumbers.size());
    //primes.forEach(System.out::println);


    public static void main(String[] args) {
        List<Integer> primeNumbers = new LinkedList<>();

        for (int i = 2; i < 1000000; i++) {
            if (tools.isItPrime(i)) {
                primeNumbers.add(i);
                tools.d(i);

            }
        }
        d("d: " + primeNumbers.size());
    }
}






