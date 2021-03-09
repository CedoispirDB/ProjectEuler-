package utils;

public class Tests3 {

    private static int findDivisors() {
        int sum = 0;
        int f;
        for (int k = 1; k <= 100000000; k++) {
            if (k % 100000 == 0){
                tools.d("We are at: " + k);
            }
            for (int d = 1; d <= k; d++) {
                if (k % d == 0) {
                    f = d + k / d;
                    if (tools.isItPrime(f)){
                        sum += k;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        tools.d(findDivisors());
        tools.d(Math.atan2(20,20));
    }
}
