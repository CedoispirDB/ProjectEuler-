import utils.tools;

public class greatestCommonDivisor {
    private static int findGCD(int a, int b) {
        int gcd = 0;
        int compare = 0;
        for (int i = 1; i <= a; i++) {
            for (int k = 1; k <= b; k++) {
                if (a % i == 0 && b % k == 0 && i == k) {
                    if (i > compare) {
                        gcd = i;
                        compare = gcd;
                    }

                }
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        tools.d(findGCD(2,10));

    }
}



