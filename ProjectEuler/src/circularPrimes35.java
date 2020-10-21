import java.util.LinkedList;
import java.util.List;

public class circularPrimes35 {

    private static final List<String> rotations = new LinkedList<>();
    private static int turns = 0;

    private static List<String> rotateNum(String sequence) {
        if (sequence == null || turns == sequence.length()) {

            turns = 0;
            return rotations;

        }
        String secondPart = sequence.substring(0, sequence.length() - 1);
        String firstPart = sequence.substring(sequence.length() - 1);
        String newSequence = firstPart + secondPart;
        rotations.add(newSequence);
        turns++;
        rotateNum(newSequence);
        return rotations;
    }

    private static int countCircularPrimes(int limit) {
        int count = 0;
        List<String> x = new LinkedList<>();
        boolean circularPrime;
        for (int i = 2; i <= limit; i++) {
            circularPrime = false;
            if (tools.isItPrime(i)) {
                x = rotateNum(String.valueOf(i));
                for (String p : x) {
                    if (tools.isItPrime(Integer.parseInt(p))) {
                        circularPrime = true;
                    } else {
                        circularPrime = false;
                        break;
                    }
                }
            }

            if (circularPrime) {
                count++;
//                tools.d("i is: " + i + ", circularPrime is: " + circularPrime + " and count is: " + count);
//                x.forEach(System.out::println);
//                tools.l("\n");
            }

            x.clear();

        }

        return count;
    }


    public static void main(String[] args) {
     tools.d(countCircularPrimes(1000000));


    }

}

