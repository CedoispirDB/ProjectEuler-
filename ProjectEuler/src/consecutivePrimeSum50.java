import java.util.ArrayList;
import java.util.List;

public class consecutivePrimeSum50 {

    public static int primeSum(int below) {
        List<Integer> primeNumbers = new ArrayList<>();

        int sum;
        int count;
        int primeResult = 0;
        int check = 0;
        int turns = 0;

        for (int i = 2; i < below; i++) {
            if (tools.isItPrime(i)) {
                primeNumbers.add(i);

            }
        }

        do {
            sum = 0;
            count = 0;

            for (int i = turns; i < primeNumbers.size(); i++) {
                sum += primeNumbers.get(i);
                count++;
                if (count > check && sum < below) {
                    if (primeNumbers.contains(sum)) {
                        primeResult = sum;
                        check = count;
                        tools.d("Sum of primes: " + sum + " with " + count + " numbers");
                    }
                } else if (sum > below) {
                    break;
                }
            }
            turns++;
        } while (turns <= primeNumbers.size());

        return primeResult;
    }

    public static void main(String[] args) {
        tools.d("Prime: " + primeSum(1000000));

    }

}