package utils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class tools {

    //Print a list of Integers
    public static void l(List<Integer> a, int b) {
        a.forEach(System.out::println);
    }

    //Print a list of Longs
    public static void l(List<Long> k, long l) {
        k.forEach(System.out::println);
    }

    //Print a list of Strings
    public static void l(List<String> c) {
        c.forEach(System.out::println);
    }

    //Formatting a number
    public static void format(double in) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println(decimalFormat.format(in));
    }

    //Print value in the same line line
    public static void d(Object x) {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " : " + x);
    }

    public static void d(Object x, int j) {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " : " + x + "\n");
    }

    //Print value without date
    public static void i(Object x) {
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

    //Print if the number is prime and its divisors
    public static void isItPrime(long x, int o) {
        List<Long> divisors = new LinkedList<>();
        long sumOfDivisors = 0;
        boolean isItP = true;
        for (long i = 1; i < x; i++) {
            if (x % i == 0) {
                divisors.add(i);
                sumOfDivisors += i;
                if (sumOfDivisors > 1) {
                    isItP = false;
                }
            }
        }
        if (isItP) {
            d("Number: " + x + " is prime." + "\n" + "and its divisors are: ");
        } else {
            d("Number: " + x + " is not prime." + "\n" + "and its divisors are: ");
        }
        l(divisors, 0L);

    }


    //Find the factorial of a number
    public static BigInteger factorialOfNumberB(long n) {
        BigInteger factorial = BigInteger.valueOf(1);
        int x = Integer.parseInt(String.valueOf(n));
        for (long i = 1; i <= x; i++) {
            BigInteger ib = BigInteger.valueOf(i);
            factorial = factorial.multiply(ib);
            //utils.tools.d(factorial);
        }
        //utils.tools.d("y: " + factorial);
        return factorial;

    }

    //Find the factorial of a number - returns a long
    public static long factorialOfNumber(long n) {
        long factorial = 1;
        for (long i = 1; i <= n; i++) {
            factorial = factorial * i;
            //utils.tools.d(factorial);
        }
        //utils.tools.d("y: " + factorial);
        return factorial;

    }

    //Find the factorial of a number - returns a int
    public static int factorialOfNumber(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            //utils.tools.d(factorial);
        }
        //utils.tools.d("y: " + factorial);
        return factorial;

    }


    //Find the sum of all the divisors of a number
    public static long sumOfDivisors(long x){
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
        return (long) Math.pow(x, e);
    }

    public static BigInteger exponentB(long x, long e) {
        BigInteger xB = BigInteger.valueOf(x);
        return xB.pow(2);
    }


    public static void main(String[] args) {
        isItPrime(93, 0);

    }
}






