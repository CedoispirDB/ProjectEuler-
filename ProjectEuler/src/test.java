import utils.tools;

import java.util.LinkedList;

public class test {

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


    public static void main(String[] args) {
//        tools.d(checkIfIsPermutations(4817, 8487, 8147));
        StringBuilder a = new StringBuilder();
        int x = 3;
        int y = 9;
        int w = 8;
        a.append(x);
        a.append(y);
        a.append(w);
        tools.d(a);
    }
}
