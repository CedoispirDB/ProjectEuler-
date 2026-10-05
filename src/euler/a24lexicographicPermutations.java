package euler;

import utils.tools;

public class a24lexicographicPermutations {
    private static int count = 0;

    //The the number of permutations of a sequence
    public static int findPermutations(String sequence, String ans, int p) {

        // If string is empty
        if (sequence.length() == 0) {
            count++;
           //System.out.println("Permutation number " + count + " is " + ans + " ");
            if (count == p) {
                tools.d(ans);

            }
            return count;

        }

        for (int n = 0; n < sequence.length(); n++) {

            // ith character of str
            char digit = sequence.charAt(n);

            // Rest of the string after excluding
            // the ith character
            String rest = sequence.substring(0, n) + sequence.substring(n + 1);

            // Recursive call
            findPermutations(rest, ans + digit, p);
        }

        return count;
    }


    public static void main(String[] args) {
        
        tools.d(findPermutations("0123456789", "", 1000000));
    }

}
