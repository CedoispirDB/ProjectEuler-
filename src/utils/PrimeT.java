package utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeT {
    private static final List<Integer> primes = new ArrayList<>(List.of(2));

    private static int candidate = 3;

    public static int prime(int index) {
        if(index < 1) {
            throw new IllegalArgumentException("index must be positive");
        }

        while(primes.size() < index) {
            boolean isPrime = true;

            for(int p : primes) {
                if(p > candidate / p) break;

                if(candidate % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                primes.add(candidate);
            }

            candidate += 2;
        }

        return primes.get(index - 1);
    }

}