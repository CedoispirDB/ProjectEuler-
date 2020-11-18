package utils;

import java.util.LinkedList;
import java.util.List;

public class Tests {

    private static boolean compareMultiples(int a, int b) {
        boolean sameMultiples = false;
        boolean leave = false;
        if (Math.max(a,b) % Math.min(a,b) == 0){
            return true;
        }
        for (int i = 1; i <= a; i++) {
            for (int k = 2; k <= b; k++) {
                if (a % i == 0 && b % k == 0 && i == k) {
                    sameMultiples = true;
                    leave = true;
                    break;
                }
            }
            if (leave) {
                break;
            }
        }
        return sameMultiples;
    }

    private static int totientFunction(int k) {
        int phi = 0;
        for (int i = 1; i <= k; i++) {
            if (!compareMultiples(i, k)) {
                phi++;
            }

        }
        return phi;
    }



    private static double findMax(int limit) {
        List<Double> nPhi = new LinkedList<>();
        List<Integer> n = new LinkedList<>();
        double max;
        double quotient;
        double quotient2;
        double check = 0;

        for (int i = 2; i <= limit; i++) {
            n.add(i);
        }

//        tools.d(n.size());
//        n.forEach(System.out :: println);

        for (int k = 0; k < (n.size() / 2) + 1; k++) {
            quotient = n.get(k) / (double) totientFunction(n.get(k));
//            tools.d("k: " + (k + 1));
//            tools.d("quotient: " + quotient);
            quotient2 = n.get(n.size() - k - 1) / (double) totientFunction(n.get(n.size() - k - 1));
//            tools.d("quotient2: " + quotient2 + "\n");
            max = Math.max(quotient, quotient2);

            if (max > check) {
                check = max;
            }
        }

//        for (double k : nPhi) {
//            if (k > check) {
//                check = k;
//                max = k;
//            }
//        }

        return check;
    }

    public static void main(String[] args) {
        tools.d("Max: " + findMax(1000000));

//        List<Integer> k = new LinkedList<>();
//        k.add(2);
//        int a;
//        int b;
//        int max;
//        int check = 0;
//        // 10 - 9; 8 - 6; 1 -4; 2 - 3; 5-7
//        for (int i = 0; i < k.size(); i++) {
//
//            a = k.get(i);
////            tools.d("a: " + a);
//            b = k.get(k.size() - i - 1);
////            tools.d("b: " + b);
//
//            max = Math.max(a, b);
//
//            if (max > check) {
//                check = max;
//            }

//        }

//        tools.d(check);
//        tools.d(totientFunction(999998));
//        for (int i = 2; i <= 1000 ; i++) {
//            tools.d(totientFunction(i));
//        }
    }



}