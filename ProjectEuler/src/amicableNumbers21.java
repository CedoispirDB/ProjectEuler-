import java.util.*;

public class amicableNumbers21 {
    //Find the divisors of a number
    public static int sumOfDivisors(int x) {
        int sumOfDivisors = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                sumOfDivisors += i;
            }
        }
        return sumOfDivisors;
    }
    //Make a list of amicable numbers
    public static Set<Integer> amicableNumbers(int k) {
        Set<Integer> amicableNumbers = new LinkedHashSet<>();
        int b;
        int da;
        int db;

        for (int a = 1; a <= k; a++) {
            da = sumOfDivisors(a);
            b = da;
            db = sumOfDivisors(b);
            // tools.d(da);
            //tools.d(db);
            if(db == a && a!= b) {
                amicableNumbers.add(da);
                amicableNumbers.add(db);
            }
        }
        amicableNumbers.forEach(System.out :: println );
        return amicableNumbers;
    }

    //Sum amicable numbers
    public static int sumOfAmicableNumbers(int k){
        int sum = 0;
        for (int x : amicableNumbers(k)){
            sum += x;
        }
        return sum;
    }


    public static void main(String[] args) {
        tools.d(sumOfAmicableNumbers(10000));

    }

}
