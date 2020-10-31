package euler;

import java.util.*;
import utils.tools;


public class amicableNumbers21 {
    //Make a list of amicable numbers
    public static Set<Integer> amicableNumbers(int k) {
        Set<Integer> amicableNumbers = new LinkedHashSet<>();
        int b;
        int da;
        int db;

        for (int a = 1; a <= k; a++) {
            da = (int) tools.sumOfDivisors(a);
            b = da;
            db = (int) tools.sumOfDivisors(b);
            // utils.tools.d(da);
            //utils.tools.d(db);
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
