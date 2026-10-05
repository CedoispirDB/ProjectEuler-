package euler;

import utils.tools;

public class a41pandigitalPrime {
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
        int greatestPrime= 0;
        for (int i = 0; i <= 10000000; i++) {
            if (tools.isItPrime(i)){
                if (findPans(String.valueOf(i))){
                    if (i > greatestPrime){
                        tools.d(i);
                        greatestPrime = i;
                    }
                }
            }
        }

        return greatestPrime;
    }

    public static void main(String[] args) {
        // 4 hours tho
        tools.d(findPanPrime());
    }
}
