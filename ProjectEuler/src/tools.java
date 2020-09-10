import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public class tools {


    public static void format(double in) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println(decimalFormat.format(in));
    }

    public static void d(Object x) {

        System.out.println(new Timestamp(System.currentTimeMillis()) + " - " + x);
    }


    public static void l(Object x) {
        System.out.println(x);
    }

    public static boolean isItPrime(long x) {
        boolean prime = true;
        //if (x == 1) {
        //   prime = true;
        if ((x % 2 == 0 && x != 2) || (x % 3 == 0 && x != 3) || x == 1) {
            prime = false;
        } else {
            // checks if less X can be divided by w
            for (int w = 2; w < Math.floor(x / 3); w++) {
                if (x % w == 0) {
                    //tools.d(w);
                    prime = false;
                    break;

                }
            }

        }


        return prime;
    }

    public static BigInteger factorialOfNumber(long n) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (long i = 1; i <= n; i++) {
            BigInteger ib = BigInteger.valueOf(i);
            factorial = factorial.multiply(ib);
            //tools.d(factorial);
        }
        //tools.d("y: " + factorial);
        return factorial;

    }





    public static void main(String[] args) {

        // int n = 20;
        //BigInteger y = BigInteger.valueOf(121645100408832000L);

        //BigInteger x = y.multiply(BigInteger.valueOf(n));

        //tools.d("x: "  + x);

        factorialOfNumber(40);
    }


}




