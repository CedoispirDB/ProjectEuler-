package euler;
import utils.tools;

public class a3largestPrimeFactor {
    public static double factors(long x) {


        long i = 0;

        for (long v = 1; v <= x; v++) {
            if (x % v == 0) {
                if (tools.isItPrime(v)) {
                   i = v;
                    // utils.tools.d(v);
                }

            }
        }
        //BigInteger iBig = BigInteger.valueOf((long) i);
        //utils.tools.d("A factor is: " + iBig);
        return i;
    }






    public static void main(String[] args) {
        tools.d("The prime factor is: " + factors(600851475143L));

        //45 sec
        // -1104303640
        //84 sec
        //1:37

    }
}
