import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class nonAbundantSums23 {

    //Find all the abundant numbers in a range
    public static Set<Integer> abundantNumbers(int x) {
        Set<Integer> listOfAbundantNumbers = new LinkedHashSet<>();
        for (int i = 1; i < x; i++) {
            int k = tools.sumOfDivisors(i);
            //tools.d("The sum of the divisors of " + i + ": " + k);
            if (k > i) {
                listOfAbundantNumbers.add(i);
            }
        }
        //listOfAbundantNumbers.forEach(System.out::println);

        return listOfAbundantNumbers;
    }

    //Find the sum of all abundant numbers
    public static int nonAbundantNumbers(int x) {
        int totalSum = 0;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            totalSum += i;
        }
        for (int v : sumOfTwoAbundant(x)) {
            sum += v;
        }
        return totalSum - sum;
    }

    //Find the sum of two abundant numbers
    public static Set<Integer> sumOfTwoAbundant(int x) {
        int sum;
        Set<Integer> sumOfAbundantNumbers = new TreeSet<>();
        Set<Integer> o = abundantNumbers(x);
        for (int v : o) {
            for (int p : o) {
                sum = p + v;
                if (sum < x) {
                    //tools.d("Sum of " + p + " + " + v + " = " + sum);

                    sumOfAbundantNumbers.add(sum);
                }
            }

        }

        //sumOfAbundantNumbers.forEach(System.out::println);
        return sumOfAbundantNumbers;
    }

    //Another way to the same result
    /*
    public static long sumOfNonAbundant(int x) {
        Set<Integer> setOfNumbers = sumOfTwoAbundant(x);
        boolean titan;
        int i = 1;
        long sum = 0;
        for (int v : setOfNumbers) {
            titan = true;
            do {
                if (v != i) {
                    sum += i;
                    //tools.d("Sum: " + sum);
                } else {
                    titan = false;
                }
                i++;
            } while (titan);


        }
        return sum;
    }*/

    public static void main(String[] args) {
        tools.d("Sum of all the numbers which cannot be written as the sum of two abundant numbers: " + nonAbundantNumbers(28123));
        //tools.d("Sum of all the numbers which cannot be written as the sum of two abundant numbers: " + sumOfNonAbundant(28123));

    }
}
