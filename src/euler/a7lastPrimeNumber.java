package euler;
import utils.tools;

public class a7lastPrimeNumber {
    public static void findTheNthPrime(int n) {
        int count = 0;
        int i = 0;
        while (true) {

            if (tools.isItPrime(i)) {
                count += 1;
                if (count == n) {
                    tools.d("The " + n +i);
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
