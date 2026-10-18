package utils;

import java.util.LinkedList;
import java.util.List;

public class MaT {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // O(nlogn)
    public static int totient(int max) {
        int sum = 0;

        for (int i = 1; i <= max; i++) {
            if (gcd(max, i) == 1) {
                sum++;
            }
        }

        return sum;
    }

    // O(sqrt(n))
    public static long eulerProduct(long n) {
        if (n < 0) {
            return -1;
        }

        long r = n;

        for (long p = 2; p <= n / p; p++) {
            if (n % p == 0) {
                r = r - r / p;

                while (n % p == 0) {
                    n = n / p;
                }
            }
        }

        if (n > 1) {
            r = r - r / n;
        }

        return r;
    }

    //Find a common factor
    public static double leastCommonDenominator(double a, double b) {
        if (a % b == 0) {
            return b * (a / b);
        } else if (b % a == 0) {
            return a * (b / a);
        }
        List<Double> passedNum = new LinkedList<>();

        int product = 1;

        for (int i = 1; i <= Math.max(a, b); i++) {
            if (Tools.isItPrime(i)) {
                if (a % i == 0) {
                    if (a != 1 && !passedNum.contains(a)) {
                        product *= i;
                        passedNum.add(a);
                        a = a / i;
                        if (b % i == 0) {
                            b = b / i;
                        }

                    }
                }
                if (b % i == 0) {
                    if (b != 1 && !passedNum.contains(b)) {
                        product *= i;
                        passedNum.add(b);
                        b = b / i;
                        if (a % i == 0) {
                            a = a / i;
                        }
                    }
                }

            }
            if (product == Math.max(a, b)) {
                break;
            }
        }

        return product;
    }

    //Function to simplify numbers returns a list
    public static List<Integer> simplifyNum(int n, int d) {
        List<Integer> fraction = new LinkedList<>();
        int min = Math.min(n, d);
        if (n % d == 0) {
            fraction.add(n);
            fraction.add(d);
            return fraction;

        }
        if (n % min == 0 && d % min == 0) {
            n = n / min;
            d = d / min;

        } else {
            for (int i = 1; i <= min; i++) {
                if (n % i == 0 && d % i == 0) {
                    n = n / i;
                    d = d / i;
                }
            }

        }
        fraction.add(n);
        fraction.add(d);
        return fraction;
    }

    //Function to simplify numbers returns a String
    public static String simplifyNum2(int n, int d) {
        int min = Math.min(n, d);
        if (n % d == 0) {

            return n + "/" + d;

        }
        if (n % min == 0 && d % min == 0) {
            n = n / min;
            d = d / min;

        } else {
            for (int i = 1; i <= min; i++) {
                if (n % i == 0 && d % i == 0) {
                    n = n / i;
                    d = d / i;
                }
            }

        }
        return n + "/" + d;
    }

    //Function to take the square get a int as parameter
    public static int square(int x) {
        return (int) Math.sqrt(x);
    }

    //Function to find how many prime factors a number has
    public static int primeFactors(int n) {
        int factors = 0;
        for (int i = 1; i <= n; i++) {
            if (Tools.isItPrime(i)) {
                if (n % i == 0) {
                    n = n / i;
                    factors++;
                }
            }
        }
        return factors;
    }

    public static void main(String[] args) {
//        tools.d(simplifyNum(2, 2));
        //tools.d(leastCommonDenominator(15,10));
        Tools.d(primeFactors(61332));
        Tools.d(primeFactors(61334));
        Tools.d(primeFactors(61335));
        Tools.d(primeFactors(61336));
    }
}
