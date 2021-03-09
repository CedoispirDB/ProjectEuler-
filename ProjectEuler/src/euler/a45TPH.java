package euler;

import java.util.LinkedList;
import java.util.List;
import utils.tools;


public class a45TPH {
    public static void TPHSameResults(int choose) {
        List<Long> tNum = new LinkedList<>();
        List<Long> pNum = new LinkedList<>();
        List<Long> hNum = new LinkedList<>();

        int count = 0;

        for (long t = 1; t < 600000; t++) {
            tNum.add(t * (t + 1) / 2);
        }
        for (long p = 1; p < 600000; p++) {
            pNum.add(p * (3 * p - 1) / 2);
        }

        for (long h = 1; h < 600000; h++) {
            hNum.add(h * (2 * h - 1));
        }

        int x = tNum.size();
        for (long t : tNum) {
            //utils.tools.d("Missing: " + x);
            if (pNum.contains(t) && hNum.contains(t) && t >= 40755) {
                count++;
                if (count == choose) {
                    tools.d("Result: " + t);
                    System.exit(0);
                }
            }
            x--;
        }
    }

    public static void main(String[] args) {
        TPHSameResults(2);
    }
}
