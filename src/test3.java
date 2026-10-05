import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import utils.tools;

public class test3 {

    static void allSums(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;

        for (int x : partial) {
            s += x;

        }
        if (s == target)
            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);

        if (s >= target)
            return;

        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            allSums(remaining, target, partial_rec);
        }
    }

    static void sum_up(ArrayList<Integer> numbers, int target) {
        allSums(numbers, target, new ArrayList<Integer>());
    }

    public static void main(String arg[]) {
//        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        int target = 12;
//            sum_up(numbers, target);

        String[] o = new String[3];
        o[0] = "3";
        o[1] = "2";
        o[2] = "1";
        String[] p = new String[3];
        p = o;
        System.out.println(p[0]);

    }
}


