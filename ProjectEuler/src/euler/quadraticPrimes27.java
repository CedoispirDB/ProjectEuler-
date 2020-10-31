package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class quadraticPrimes27 {
    private static int productOfCoefficients(){
        int maxConsecutivePrimes = 0;

        // Build list of primes for b
        List<Integer> bVals = new LinkedList<>();
        for(int k = 1; k <= 1000; k++){
            if (tools.isItPrime(k)){
                bVals.add(k);
                bVals.add(-k);
            }
        }

        // Loop thru a values
        for (int a = 0; a <= 999; a++) {
            for (int b : bVals ) {
                // Check how many consecutive are prime
                int consecutivePrimes = 0;
                for (int n = 0; n < 100; n++) {
                    if (tools.isItPrime(n^2 + a*n + b)) {
                        consecutivePrimes++;
                    } else {
                        tools.d(consecutivePrimes + "cConsecutive Primes for n^2 + " + a + "n + "+ b);
                        if (consecutivePrimes > maxConsecutivePrimes) {
                            maxConsecutivePrimes = consecutivePrimes;
                        }
                        break;
                    }

                }
            }

        }

        return maxConsecutivePrimes;
    }

    public static void main(String[] args) {
        productOfCoefficients();
    }

}
