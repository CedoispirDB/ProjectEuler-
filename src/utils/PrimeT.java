package utils;

import java.util.List;
import java.util.LinkedList;

public class PrimeT {

    private static final LinkedList<Integer> primes = new LinkedList<>(List.of(2));

    private static int candidate = 3;

    public static int prime(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("index must be positive");
        }

        while (primes.size() < index) {
            boolean isPrime = true;

            for (int p : primes) {
                if (p > candidate / p) {
                    break;
                }

                if (candidate % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(candidate);
            }

            candidate += 2;
        }

        return primes.get(index - 1);
    }

    public static boolean isPrime(int k) {
        if(primes.contains(k)) {
            return true;
        }
        
        long sum_of_divisors = 0;
        for (long i = 1; i < k; i++) {
            if (k % i == 0) {
                sum_of_divisors += i;
                if (sum_of_divisors > 1) {
                    return false;
                }
            }
        }
        
        if(sum_of_divisors == 1) {
            primes.add(k); 
            return true;
        } else {
            return false;
        }
    }

}
