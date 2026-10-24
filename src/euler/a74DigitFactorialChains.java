package euler;

import java.util.*;
import utils.*;

public class a74DigitFactorialChains {

    private static LinkedList<Integer> visited = new LinkedList<>();

    private static int createChain(int initial) {
        if(visited.contains(initial)) {
            return visited.size();
        }

        visited.add(initial);

        String i_str = String.valueOf(initial);

        int current_sum = 0;

        for(int i = 0; i < i_str.length(); i++) {
            int digit = Tools.charToDigit(i_str.charAt(i));
            current_sum += Factorial.getFactorial(digit);
        }

        // Log.println(initial + " -> " + current_sum);
        return createChain(current_sum);
    }

    private static int solution() {
        int count = 0;

        for(int i = 0; i <= Const.ONE_MILLION; i++) {
            int chain_count = createChain(i);

            if(chain_count == 60) {
                count++;
            }

            visited.clear();
        }
        
        return count;
    }

    public static void main(String[] args) {
        Log.println("Solution: " + solution());
    }
}
