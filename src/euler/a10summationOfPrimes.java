package euler;
import utils.Tools;


public class a10summationOfPrimes {
    public static long sumOfPrimes(long n){
        long x =0;
        for (long i = 0; i<n; i++){
            if(Tools.isItPrime(i)){
                x += i;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Tools.d(sumOfPrimes(2000000));
    }
}
