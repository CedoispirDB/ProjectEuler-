package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class a49primePermutations {

    private static List<String> permutations = new LinkedList<>();

    private static List<String> findPermutations(String sequence, String ans) {

        // If string is empty
        if (sequence.length() == 0) {

            permutations.add(ans);
            return permutations;

        }

        for (int n = 0; n < sequence.length(); n++) {

            // ith character of str
            char digit = sequence.charAt(n);

            // Rest of the string after excluding
            // the ith character
            String rest = sequence.substring(0, n) + sequence.substring(n + 1);

            // Recursive call
            findPermutations(rest, ans + digit);
        }

        return permutations;
    }

    private static void conPer(){
        for(String p : findPermutations("1487", "")){
            if (tools.isItPrime(Long.parseLong(p))){
                tools.d(p);
            }
        }
    }


    public static void main(String[] args) {
        //findPermutations("1487", "").forEach(System.out :: println);
        conPer();
    }
}
