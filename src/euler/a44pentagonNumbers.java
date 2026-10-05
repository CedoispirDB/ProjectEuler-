package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class a44pentagonNumbers {
    private static List<Long> pentaNumbers() {
        List<Long> penta = new LinkedList<>();
        for (int i = 1; i <= 10000; i++) {
            penta.add((long) (i * (3 * i - 1) / 2));

        }
        return penta;
    }

    private static long findD() {
        long sum;
        long dif;
        long result = 1;
        for (long i : pentaNumbers()) {
            for (long j : pentaNumbers()) {
                sum = i + j;
                if (pentaNumbers().contains(sum)) {
                    dif = i - j;
                    if (pentaNumbers().contains(dif) && dif > 0){
                        tools.d(i + " + " + j + " = " + sum);
                        tools.d(i + " - " + j + " = " + dif);
                        result = j - i;
                        return Math.abs(result);
                    }

                }
            }
        }
        return Math.abs(result) ;
    }

    public static void main(String[] args) {
        tools.d(findD());
    }
}
