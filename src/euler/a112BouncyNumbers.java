package euler;

import java.util.*;
import utils.*;

public class a112BouncyNumbers {

    public static void main(String[] args) {

        long bouncy_count = 0;
        long total = 99;
        int n = 100;

        while(true) {
            String str = String.valueOf(n);

            boolean bouncy = false;
            char code = '\0';
            char base = str.charAt(0);

            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (base > c) {
                    if (code != '\0' && code != 'd') {
                        bouncy = true;
                        // break;
                    }
                    code = 'd';
                } else if (base == c) {
                } else {
                    if (code != '\0' && code != 'i') {
                        bouncy = true;
                        // break;
                    }
                    code = 'i';
                }
                base = c;
            }

            if (bouncy) {
                bouncy_count++;
            }

            total++;

            double p = (double)bouncy_count / total;
            // Log.println("%: " + p);
            if (bouncy_count  * 100L == total * 99L) {
                Log.println("Least: " + n);
                break;
            }

            n++;
        }

    }
}
