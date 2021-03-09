package utils;

import java.util.LinkedList;
import java.util.List;

public class Tests4 {
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

//    private static List<String> n = new LinkedList<>();
//
//
//    private static void findMultiples(int k) {
//        StringBuilder multiples = new StringBuilder();
//        if (tools.isItPrime(k)) {
//
//            n.add(String.valueOf(multiples));
//
//            return;
//        }
//        for (int i = 2; i < k; i++) {
//            if (k % i == 0) {
//                multiples.append(i);
//            }
//        }
//
//        n.add(String.valueOf(multiples));
//
//
//    }
//
//    private static void addList() {
//
//        for (int i = 2; i <= 20; i++) {
//            n.add(String.valueOf(i));
//            findMultiples(i);
//        }
//
//    }

    private static List<Integer> n = new LinkedList<>();


    private static void findMultiples(int k) {
        StringBuilder multiples = new StringBuilder();
        if (tools.isItPrime(k)) {

            n.add(Integer.parseInt(String.valueOf(k)));

            return;
        }
        for (int i = 2; i < k; i++) {
            if (k % i == 0) {
                n.add(Integer.parseInt(String.valueOf(i)));
            }
        }


    }

    private static void addList() {

        for (int i = 2; i <= 20; i++) {
            n.add(i);
            findMultiples(i);
        }

    }

//    private static int totient2(int k, int a) {
//
//        if (tools.isItPrime(k)) {
//            return k - 1;
//        }
//
//        int phi = 0;
//        int kPos;
//        int iPos;
//        int kMul;
//        int iMul;
//        boolean f = false;
//
//        kPos = n.indexOf(String.valueOf(k));
//        kMul = Integer.parseInt(n.get(kPos + 1));
//
//        for (int i = 2; i < k; i++) {
//            iPos = n.indexOf(String.valueOf(i));
//            iMul = Integer.parseInt(n.get(iPos + 1));
//            tools.d("For: " + i);
//            tools.d("kMul: " + kMul);
//            tools.d("iMul: " + iMul);
//
//            for (int j = 0; j < String.valueOf(iMul).length(); j++) {
////                tools.d(String.valueOf(iMul).charAt(j));
//                if (!(String.valueOf(kMul).contains(String.valueOf(String.valueOf(iMul).charAt(j))))) {
//                    f = true;
//                } else {
//                    f = false;
//                    break;
//                }
//            }
//            if (f) {
//                phi++;
//            }
//            tools.d("phi: " + phi);
//            tools.i();
//        }
//        return phi + 1;
//    }
//
//    private static int totient2(int k) {
//        int phi = 0;
//        int kPos;
//        int iPos;
//        int kMul;
//        int iMul;
//        boolean f = false;
//
//        kPos = n.indexOf(String.valueOf(k));
//        kMul = Integer.parseInt(n.get(kPos + 1));
//
//        for (int i = 2; i < k; i++) {
//            iPos = n.indexOf(String.valueOf(i));
//            iMul = Integer.parseInt(n.get(iPos + 1));
////            tools.d("For: " + i);
////            tools.d("kMul: " + kMul);
////            tools.d("iMul: " + iMul);
//
//            for (int j = 0; j < String.valueOf(iMul).length(); j++) {
////                tools.d(String.valueOf(iMul).charAt(j));
//                if (!(String.valueOf(kMul).contains(String.valueOf(String.valueOf(iMul).charAt(j))))) {
//                    f = true;
//                } else {
//                    f = false;
//                    break;
//                }
//            }
//            if (f) {
//                phi++;
//            }
////            tools.d("phi: " + phi);
////            tools.i();
//        }
//        return phi + 1;
//    }

    public static void main(String[] args) {
        addList();
        n.forEach(System.out::println);

        int k = 6;
        int i = 2;

        int kPos;
        int kMul;
        int kFin;
        int iPos;
        int iMul;
        int iFin;

        kPos = n.indexOf(k);
        iPos = n.indexOf(i);

        kFin = n.indexOf(kPos + 1);
        iFin = n.indexOf(iPos + 1);

//        tools.d("Multiples of " + k);
//        for (int j = kPos; j <= kFin ; j++) {
//            tools.d(n.get(j));
//        }
//        tools.d("Multiples of " + i);
//        for (int j = iPos; j <= iFin; j++) {
//            tools.d(n.get(j));
//        }

        tools.d("kPos: " + kPos);
        tools.d("iPos: " + iPos);
        tools.d("kFin: " + kFin);
        tools.d("iFin: " + iFin);


        tools.i();
//        for (int k = 1; k <= 15; k++) {
//            tools.d("For: " + k);
//            tools.d("1: " + totientFunction(k));
//            tools.d("2: " + totient2(k));
//            tools.i();
//        }

//        tools.d(
//       "1: " + totientFunction(k));
        //9
        //12
        //13
        //14
        //15
//        tools.d(totient2(k, 0));

    }

}
