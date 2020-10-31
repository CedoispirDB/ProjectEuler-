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
        boolean check = true;
//        for (int a = 1; a <= 1000; a++) {
//            for (int b = 1; b <= 1000; b++) {
//                if (utils.tools.isItPrime(a) && !utils.tools.isItPrime(b)) {
//                    int x = findGCD(a, b);
//                    //utils.tools.d(findGCD(a, b));
//                    if (x != 1) {
//                        check = false;
//                    }
//                }
//            }
//        }

        tools.d(findGCD(4,9));
//        if (check) {
//            utils.tools.d("You are right!!!");
//        } else {
//            utils.tools.d("You are wrong :(");
//        }
    }
}



