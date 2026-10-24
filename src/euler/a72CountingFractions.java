package euler;

import java.util.*;
import utils.*;

public class a72CountingFractions {

    private static int solution(int max) {
        int test_fraction = (max - 1) * max - sum_up(max - 1);
        int test_even = sum_up((int)((double)max / 2) - 1);
        int test_improper = 0;

        for (int d = 2; d <= max; d++) {
            // Log.println("Current on: " + d);
            test_improper += count_divisors(d);
        }

        Log.printfln("Used: ");
        Log.printfln("test_fraction: %d, test_even: %d, test_improper: %d", test_fraction, test_even, test_improper);
        int r = test_fraction - (test_even + test_improper);
        return r;
    }

    private static int sum_up(int limit) {
        int count = 0;
        for(int i = 1; i <= limit; i++) {
            count += i;
        }

        return count;
    }

    private static int count_divisors(int limit) {
        int count = 0;
        for(int i = 2; i < limit; i++) {
        
            if(limit % 2 == 0 && i % 2 == 0) {
                // count--;
                continue;
            }
            
            if(limit % i == 0) {
                count++;
            }
        }   

        return count;
    }

    private static void test(int max) {
        int invalid_even = 0;
        int invalid_improper = 0;
        int fractions = 0;
        int valid = 0;

        int current = 0;
        int test_improper = 0;

        for (int d = 2; d <= max; d++) {
            // Log.println("d: " + d);
            // if (!((d >= 2 && n >= 2) && (d % 2 == 0 && n % 2 == 0))) {
            // test_improper += count_divisors(d);
            // }  
            for (int n = 1; n < d; n++) {
                Log.printf("%d / %d (%d)", n, d, Mat.gcd(d, n));
                fractions++;
                if ((d >= 2 && n >= 2) && (d % 2 == 0 && n % 2 == 0)) {
                    invalid_even++;
                    Log.println(" - (even)");
                } else 
                if (n != 1 && d % n == 0) {
                    invalid_improper ++;
                    Log.println(" - (not reduced)");
                    current++;
                } else {
                    Log.skip_line();
                    valid++;
                }
            }
            // if(current != -2) {
            //     Log.print("d: " + d + " -> ");
            //     Log.printfln("%d", current); 
            // } else {
            // }
                Log.skip_line();            
            current = 0;
        }

        Log.printfln("even: %d\nnot reduced: %d\nvalid: %d\nfractions: %d", invalid_even, invalid_improper, valid, fractions);
        int test_even = sum_up((int)((double)max / 2) - 1);
        Log.println("test_even: " + test_even);
        Log.println("test_improper: " + test_improper);
        int test_fraction = (max - 1) * max - sum_up(max - 1);
        Log.println("test_fractions: " + test_fraction);

    }

    public static void main(String[] args) {
        // int max = Const.ONE_MILLION;
        int max = 8;
        // test(max);
        // Log.skip_line();
        Log.println("Solution: " + solution(max));
    }
}
