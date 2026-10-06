package euler;

import java.util.*;

public class a93ArithmeticExpressions {

    public static List<int[]> findPermutations(int[] opts) {
        List<int[]> results = new ArrayList<>();
        backtrack(0, opts, results);
        return results;
    }

    private static void backtrack(int start, int[] opts, List<int[]> results) {
        if (start == opts.length) {
            // if(opts[0] < 0 || opts[opts.length - 1] < 0) return; // dont end or start with sign
            // if(opts[2] < 0 || opts[4] < 0) return; // dont have sign after sign
            results.add(Arrays.copyOf(opts, opts.length));
            return;
        }

        for (int i = start; i < opts.length; i++) {
            int temp = opts[start];
            opts[start] = opts[i];
            opts[i] = temp;

            backtrack(start + 1, opts, results);

            temp = opts[start];
            opts[start] = opts[i];
            opts[i] = temp;
        }

    }

    private static void test() {
        int goal = 1;

        int[] opts = {1, 2, 3, 4};

        // test possible sums/subtractions
        int sum = opts[0] + opts[1] + opts[2] + opts[3];

        int diff = opts[0] - opts[1] - opts[2] - opts[3];
        
        List<int[]> optsPerm = findPermutations(opts);

        // Exibe o resultado formatado no console
        System.out.println("Total " + optsPerm.size());
        for (int[] perm : optsPerm) {
            System.out.println(Arrays.toString(perm));
        }
    }

    public static void main(String[] args) {
        test();
        List<String> symbols  = List.of("+", "-", "*", "/");  
        
        symbols.get(start);
    }
}
