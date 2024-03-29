import utils.tools;

public class eulersTotientFunction {

    private static boolean compareMultiples(int a, int b) {
        boolean sameMultiples = false;
        boolean leave = false;
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

    public static void main(String[] args) {
//        for (double i = 2; i <= 50; i++) {
//            tools.d("For " + (int) i + ": " + (i  / (double)totientFunction((int)i)));
//        }
        tools.d("Start");
        tools.d(totientFunction(999998));
    }
}
