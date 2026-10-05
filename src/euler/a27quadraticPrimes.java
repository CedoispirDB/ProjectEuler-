package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class a27quadraticPrimes {
    private static int productOfCoefficients() {
        int maxConsecutivePrimes = 0;
        int product = 0;

        // Build list of primes for b
        List<Integer> bVals = new LinkedList<>();
        for (int k = 1;
             k <= 1000; k++) {
            if (tools.isItPrime(k)) {
                bVals.add(k);
                bVals.add(k * -1);
            }
        }

        // Loop thru a positive values
        //tools.d("\n--Looping thru positive a values");
        for (int a = 0; a < 1000; a++) {
            for (int b : bVals) {
                // Check how many consecutive are prime
                int consecutivePrimes = 0;
                for (int n = 0; n < 1000; n++) {
                    //tools.d(" Checking Primes for n^2 + " + a + "*n + "+ b);
                    if (tools.isItPrime((tools.exponent(n, 2)) + (a * n) + b)) {
                        if (consecutivePrimes > maxConsecutivePrimes) {
                            //tools.d(consecutivePrimes + " Consecutive Primes for n^2 + " + a + "*n + " + b);
                            maxConsecutivePrimes = consecutivePrimes;
                            product = a * b;
                        }
                        consecutivePrimes++;
                    }  else {
                        break;
                    }

                }
            }

        }

        // Loop thru a negative values
        //tools.d("\n--Looping thru negative a values");
        for (int a = 0; a < 1000; a++) {
            for (int b : bVals) {
                // Check how many consecutive are prime
                int consecutivePrimes = 0;
                for (int n = 0; n < 1000; n++) {
                    //tools.d(" Checking Primes for n^2 + " + a + "*n + "+ b);
                    if  (tools.isItPrime((tools.exponent(n, 2)) - (a * n) + b)) {
                        if (consecutivePrimes > maxConsecutivePrimes) {
                            //tools.d(consecutivePrimes + " Consecutive Primes for n^2 - " + a + "*n + " + b);
                            maxConsecutivePrimes = consecutivePrimes;
                            product = a * b;
                        }
                        consecutivePrimes++;
                    } else {
                        break;
                    }

                }
            }

        }

        return product;
    }

    public static void main(String[] args) {
        tools.d("Product: " + productOfCoefficients());
    }

}
