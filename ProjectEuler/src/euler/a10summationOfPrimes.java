package euler;
import utils.tools;


public class a10summationOfPrimes {
    public static long sumOfPrimes(long n){
        long x =0;
        for (long i = 0; i<n; i++){
            if(tools.isItPrime(i)){
                x += i;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        tools.d(sumOfPrimes(2000000));
    }
}
