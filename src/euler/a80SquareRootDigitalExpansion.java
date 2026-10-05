package euler;

import java.math.*;

public class a80SquareRootDigitalExpansion {

    public static void main(String[] args) {

        BigDecimal curr;
        BigDecimal sqrt;
        MathContext mc = new MathContext(101);

        int decimal_sum = 0;

        for (int d = 1; d <= 100; d++) {
            curr = new BigDecimal(d);
            sqrt = curr.sqrt(mc);

            double mod = sqrt.remainder(BigDecimal.ONE).doubleValue();
            System.out.println("For: " + sqrt + " mod: " + mod);
            if(mod == 0) continue;

            String str = sqrt.toString();
            
            System.err.println("Calculating: " + str);
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == '.') {
                    continue;
                }
                decimal_sum += Integer.valueOf(String.valueOf(str.charAt(i)));
                // System.out.println(i + ") " + str.charAt(i));
            }

        }
        System.out.println(decimal_sum);
    }
}
