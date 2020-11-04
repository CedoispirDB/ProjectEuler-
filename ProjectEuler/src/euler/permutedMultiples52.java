package euler;

import utils.tools;

import java.util.*;

public class permutedMultiples52 {
    private static int putNumbersInOrder(int x) {
        StringBuilder wait = new StringBuilder(String.valueOf(x));
        StringBuilder newW = new StringBuilder();

        while (wait.length() != 1) {
            int a = Integer.parseInt(String.valueOf(wait.charAt(1)));
            for (int i = 0; i < wait.length(); i++) {
                int a1 = Integer.parseInt(String.valueOf(wait.charAt(i)));
                a = Math.min(a1, a);


            }
            wait.deleteCharAt(wait.indexOf(String.valueOf(a)));
            newW.append(a);
        }
        newW.append(wait.charAt(0));
        return Integer.parseInt(String.valueOf(newW));

    }

    private static boolean checkDigits(int a1, int a2, int a3, int a4, int a5) {
        a1 = putNumbersInOrder(a1);
        a2 = putNumbersInOrder(a2);
        a3 = putNumbersInOrder(a3);
        a4 = putNumbersInOrder(a4);
        a5 = putNumbersInOrder(a5);


        return a1 == a2 && a2 == a3 && a3 == a4 && a4 == a5;
    }

    private static int integerSameDigits() {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int i;
        for (i = 1; i <= 200000; i++) {
            a2 = i * 2;
            a3 = i * 3;
            a4 = i * 4;
            a5 = i * 5;
            a6 = i * 6;
            if (checkDigits(a2, a3, a4, a5, a6)) {
                return i;
            }

        }
        return i;
    }

    public static void main(String[] args) {
        tools.d(integerSameDigits());
    }
}
