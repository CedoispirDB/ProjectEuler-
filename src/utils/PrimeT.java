package utils;

import java.util.List;
import java.util.LinkedList;

public class PrimeT {

    // want to make sure to leave this ordered
    // so i can get prime at index-th
    private static final LinkedList<Integer> ordered_primes = new LinkedList<>(List.of(2));
    private static int final_prime = 2;

    // unordered
    private static final LinkedList<Integer> visited_primes = new LinkedList<>();

    private static int candidate = 3;

    // adding when looking up primes in ascending order
    private static void orderedAdd(int k) {
        ordered_primes.add(k);
        visited_primes.add(k);
    }

    // adding when checking primes in random order
    private static void randomAdd(int k) {
        visited_primes.add(k);
    }

    // get index-th prime (1 indexed)
    public static int prime(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index must be greater than 0");
        }

        if (index < 1) {
            throw new IllegalArgumentException("index must be positive");
        }

        while (ordered_primes.size() < index) {
            boolean isPrime = true;

            for (int p : ordered_primes) {
                if (p > candidate / p) {
                    break;
                }

                if (candidate % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                orderedAdd(candidate);
            }

            candidate += 2;
        }

        return ordered_primes.get(index - 1);
    }


    // unordered
    public static boolean isPrime(int k) {
        if (visited_primes.contains(k)) {
            return true;
        }

        if (k != 2 && k % 2 == 0) {
            return false;
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

        if (sum_of_divisors == 1) {
            randomAdd(k);
            return true;
        } else {
            return false;
        }
    }

    public static boolean arePrime(int... ks) {

        for (int i = 0; i < ks.length; i++) {
            if (!isPrime(ks[i])) {
                return false;
            }
        }

        return true;
    }

    public static LinkedList<Integer> savedPrimes() {
        return ordered_primes;
    }

}
