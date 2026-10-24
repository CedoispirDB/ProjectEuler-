package euler;

import java.util.*;
import utils.*;

public class a62CubicPermutations {

    private static final LinkedList<String> group = new LinkedList<>();

    private static final int target_perm = 10;

    private static void check_permutations(LinkedList<String> v, LinkedList<LinkedList<String>> permutations) {

        if (v.isEmpty()) {
            return;
        }

        String base = v.get(0);
        v.remove(0);
        int[] f = new int[10];
        for (int c = 0; c < base.length(); c++) {
            f[base.charAt(c) - '0']++;
        }

        LinkedList<String> iteration = new LinkedList<>();

        iteration.add(base);

        Iterator<String> base_iterator = v.iterator();

        outer_while:
        while (base_iterator.hasNext()) {
            String current = base_iterator.next();

            int[] clone = f.clone();

            for (int c = 0; c < current.length(); c++) {
                clone[current.charAt(c) - '0']--;
            }

            for (int a : clone) {
                if (a != 0) {
                    continue outer_while;
                }
            }

            iteration.add(current);
            base_iterator.remove();
        }

        permutations.add(iteration);

        check_permutations(v, permutations);
    }

    private static boolean process_group() {
        HashMap<Integer, LinkedList<String>> frequency = new HashMap<>();

        // pair cubes with equal digit sum;
        for (int i = 0; i < group.size(); i++) {
            String cube = group.get(i);
            int sum = Mat.sumDigits(cube);

            LinkedList<String> v = frequency.get(sum);
            if (v == null) {
                frequency.put(sum, new LinkedList<>(List.of(cube)));
            } else {
                v.add(cube);
            }
        }
        // clear map
        Iterator<Map.Entry<Integer, LinkedList<String>>> iterator
                = frequency.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, LinkedList<String>> e = iterator.next();

            if (e.getValue().size() < target_perm) {
                iterator.remove();
            }
        }

        LinkedList<LinkedList<String>> permutations = new LinkedList<>(); // per sum group

        iterator = frequency.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, LinkedList<String>> e = iterator.next();
            LinkedList<String> v = e.getValue(); // sum group

            check_permutations(v, permutations);
        }

        LinkedList<LinkedList<String>> possible_results = new LinkedList<>(); // array of with the amount of permutations expected

        Iterator<LinkedList<String>> end = permutations.iterator();

        while (end.hasNext()) {
            LinkedList<String> check = end.next();

            if (check.size() == target_perm) {
                check.sort(null);
                possible_results.add(check);
                continue;
            }
            end.remove();
        }

        if (!possible_results.isEmpty()) {
            Log.println("Solution:");
            Log.list(possible_results);

            return true;
        } else {
            return false;
        }
    }

    // O(N^2 * log N) talvez
    public static void main(String[] args) {
        long n = 5;

        long cube = Mat.cube(n);
        String cube_str = String.valueOf(cube);

        int group_len = cube_str.length();
        int cube_len = group_len;
        group.add(cube_str);
        n++;

        while (true) {
            cube = Mat.cube(n);
            cube_str = String.valueOf(cube);
            cube_len = cube_str.length();

            if (cube_len != group_len) {
                Log.println("Processing group of size: " + group_len);
                if (process_group()) {
                    break;
                }
                group.clear();
                group_len = cube_len;
            }

            group.add(cube_str);

            n++;
        }
    }
}
