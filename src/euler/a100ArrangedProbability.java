package euler;

import java.math.*;

class a100ArrangedProbability {

    private static void run() { 
        BigInteger start = BigInteger.TEN.pow(12);
        // BigInteger start = BigInteger.valueOf(20);

        BigInteger mod = BigInteger.ONE;

        BigInteger factor = BigInteger.ZERO;

        BigInteger diff = BigInteger.ONE;

        while (!mod.equals(BigInteger.ZERO)) {
            factor = factor.add(BigInteger.ONE);
            BigInteger sum = start.add(factor);
            
            diff = sum.pow(2).subtract(sum);
            
            mod = diff.mod(BigInteger.TWO);
            System.out.println("diff: " + diff);
            System.out.println("mod:" + mod);
        }

        BigInteger k = start.add(factor);


        BigInteger delta
                = BigInteger.valueOf(4)
                        .add(BigInteger.valueOf(8).multiply(diff))
                        .sqrt();

        BigInteger x1
                = BigInteger.TWO.subtract(delta).divide(BigInteger.valueOf(4));

        BigInteger x2
                = BigInteger.TWO.add(delta).divide(BigInteger.valueOf(4));

        System.out.println("k: " + k);
        System.out.println("x1: " + x1 + " x2: " + x2);

    }

    private static void testing() {
        int minimal  = 20;
        
    }

    public static void main(String[] args) {
        run();
    }
}
