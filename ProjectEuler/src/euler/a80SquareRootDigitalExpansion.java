package euler;

import java.math.*;

public class a80SquareRootDigitalExpansion {

    public static void main(String[] args) {

        BigDecimal curr = new BigDecimal(2);

        BigDecimal sqrt = curr.sqrt(new MathContext(100));

        String str = sqrt.toString();

        for(int i = 0; i < str.length(); i++) {
            
        }

        System.out.println(str);
    }
}