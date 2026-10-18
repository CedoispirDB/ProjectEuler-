package euler;
import utils.Tools;

public class a7lastPrimeNumber {
    public static void findTheNthPrime(int n) {
        int count = 0;
        int i = 0;
        while (true) {

            if (Tools.isItPrime(i)) {
                count += 1;
                if (count == n) {
                    Tools.d("The " + n +i);
                    break;
                }

            }
            i++;

        }
    }

    public static void main(String[] args) {
        findTheNthPrime (10001);
    }
}
