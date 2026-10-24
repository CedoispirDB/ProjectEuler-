package utils;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

    private static final HashMap<Long, Long> visited_factorial = new HashMap<>(Map.of(0L, 1L));
    private static long highest_calculated = 0L;

    public static long getFactorial(long n) {
        Long r = visited_factorial.get(n);
        if (r != null) {
            return r;
        }

        r = calculateFactorial(n);

        if (n > highest_calculated) {
            highest_calculated = n;
        }

        visited_factorial.put(n, r);

        return r;
    }

    private static long calculateFactorial(long n) {
        Long total;
        long start;

        if (n < highest_calculated) {
            total = 1L;
            start = 1;
        } else {
            total = visited_factorial.get(highest_calculated);
            start = highest_calculated + 1;
        }
        if (total == null) {
            throw new NullPointerException("value for key: " + highest_calculated + " should not be null");
        }

        for (long i = start; i <= n; i++) {
            total *= i;
        }

        return total;
    }
}
