package utils;

import utils.tools;

import java.util.LinkedList;
import java.util.List;


public class Tests {

    private static boolean findPans(String x) {
        int greatstN = 0;
        for (int i = 9; i >= 0; i--) {
            if (x.contains(String.valueOf(i))) {
                greatstN = i;
                break;
            }
        }
        boolean isPan = false;
        if (x.length() != greatstN) {
            return false;
        }
        for (int i = 1; i <= greatstN; i++) {
            if (x.contains(String.valueOf(i))) {
                isPan = true;
            } else {
                isPan = false;
                break;
            }
        }
        return isPan;

    }

    private static int findPanPrime() {
        int greatestPrime = 10000000;
        for (int i = 10000000; i > 7126543; i--) {
            if (tools.isItPrime(i)) {
                if (findPans(String.valueOf(i))) {
                    if (i < greatestPrime) {
                        tools.d(i);
                        greatestPrime = i;
                    }
                }
            }
        }

        return greatestPrime;
    }

    public static void main(String[] args) {
        tools.d(findPanPrime());
    }


}




