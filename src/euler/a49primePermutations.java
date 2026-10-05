package euler;

import utils.tools;
import utils.mathTools;

import java.util.LinkedList;
import java.util.List;

public class a49primePermutations {

    private static final List<String> permutations = new LinkedList<>();

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

    private static boolean checkPermutations(int x, int y) {
        List<String> per = findPermutations(String.valueOf(x), "");
        return per.contains(String.valueOf(y));

    }

    private static boolean checkIfIsPermutations(int a, int b, int c) {
        boolean ans = false;

        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String strC = String.valueOf(c);

        StringBuilder comp1 = new StringBuilder();
        StringBuilder comp2 = new StringBuilder();
        StringBuilder comp3 = new StringBuilder();


        LinkedList<Character> aChars = new LinkedList<>();
        LinkedList<Character> bChars = new LinkedList<>();
        LinkedList<Character> cChars = new LinkedList<>();


        for (int i = 0; i < strA.length(); i++) {
            aChars.add(strA.charAt(i));
        }

        for (int i = 0; i < strB.length(); i++) {
            bChars.add(strB.charAt(i));
        }

        for (int i = 0; i < strC.length(); i++) {
            cChars.add(strC.charAt(i));
        }


        java.util.Collections.sort(aChars);
        java.util.Collections.sort(bChars);
        java.util.Collections.sort(cChars);

        for (char n : aChars) {
            comp1.append(n);
        }

        for (char n : bChars) {
            comp2.append(n);
        }

        for (char n : cChars) {
            comp3.append(n);
        }

        if (comp1.toString().equals(comp2.toString()) && comp2.toString().equals(comp3.toString())) {
            ans = true;
        }


        return ans;
    }

    private static StringBuilder newSequence(int b, int e) {

        StringBuilder ans = new StringBuilder();

        boolean leave = false;

        int diff1 = 0;
        int diff2 = 0;

        for (int n0 = b; n0 < e; n0++) {
            ans.setLength(0);
            for (int n1 = b; n1 < e; n1++) {
                for (int n2 = b; n2 < e; n2++) {
                    diff1 = n1 - n0;
                    diff2 = n2 - n1;
                    if (diff1 == diff2) {
                        if (n0 != n1 && n1 != n2) {
                            if (tools.isItPrime(n0) && tools.isItPrime(n1) && tools.isItPrime(n2)) {
                                if (checkIfIsPermutations(n0, n1, n2)) {
                                    tools.d("n0: " + n0);
                                    tools.d("n1: " + n1);
                                    tools.d("n2: " + n2);
                                    ans.append(n0);
                                    ans.append(n1);
                                    ans.append(n2);
                                    leave = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (leave) {
                    break;
                }
            }
           if (leave) {
               break;
           }
        }

        return ans;
    }


    public static void main(String[] args) {
        tools.d("Answer: " + newSequence(1488, 10000));
    }
}
