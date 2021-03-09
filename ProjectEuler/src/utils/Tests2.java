package utils;

import java.util.LinkedList;
import java.util.List;

public class Tests2 {

    private static void nao() {
        List<Integer> d = new LinkedList<>();
        String str = "8281";

        for (int i = 0; i < str.length(); i++) {
            d.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }

        d.forEach(System.out::println);


    }

    private static boolean compareMultiples(int a, int b) {
        if (Math.max(a, b) % Math.min(a, b) == 0) {
            return true;
        }

        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }

    private static int totientFunction(int k) {
        int phi = 0;
        if (k == 1) {
            return 1;
        }
        if (tools.isItPrime(k)) {
            return k - 1;
        }
        for (int i = 1; i <= k; i++) {
            if (i % 100000 == 0) {
                tools.d("I'm at: " + i);
            }
            if (i == 1) {
                phi++;
            }
            if (!compareMultiples(i, k)) {
                phi++;
            }
        }
        return phi;
    }


    public static void main(String[] args) {

        for (int i = 100000; i <= 1000000; i = i + 100000) {
            tools.d("Start for: " + i);
            totientFunction(i);
            tools.d("End" + "\n");
        }


//        nao();


        String s = "8281";
        int sum = 0;
//        StringBuilder check = new StringBuilder();
//
//        int k = Integer.parseInt(String.valueOf(s.charAt(1)));
//        k = Integer.parseInt(s.substring(0, 3));
//        CharSequence kc = String.valueOf(k);
//
//        for (int j = 1; j < s.length(); j++) {
//            k = Integer.parseInt(s.substring(0, j));
//
//            for (int i = 0; i < s.length(); i++) {
//                String h = s.substring(i);
////            tools.d("h: " + h);
////            tools.d("k: " + k);
//                check.append(h).append(k);
//
//                if (check.length() == s.length() && !h.contains(kc)) {
//                    sum = k + Integer.parseInt(h);
//                    tools.d(k + " + " + h + " = " + sum);
//
//                }
//                check.setLength(0);
//            }
//        }
//        tools.d("Sum: " + sum);
    }
}