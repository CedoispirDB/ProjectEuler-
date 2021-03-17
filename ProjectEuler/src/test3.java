import java.math.BigDecimal;

import utils.tools;

public class test3 {
    public static void main(String[] args) {
        long k = 3;
        long l = 7;
        long prevN = 0;
        long product = 0;
        for (int n = 0; n <= 1000000 ; n++) {
            tools.d(n);
            for (int d = 1; d <= 1000000; d++) {
                product = (k * d) / l;
                if (n < product && n >= prevN) {
                    prevN = n;

                }
            }
        }
        tools.d(prevN);
    }
}
