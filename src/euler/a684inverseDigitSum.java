package euler;

import utils.tools;

public class a684inverseDigitSum {

    private static int findSmallestNum(int n) {
        String iS;
        int sum = 0;
        for (int i = 1; i < 9999999; i++) {
            iS = String.valueOf(i);
            for (int j = 0; j < iS.length(); j++) {
                sum += Integer.parseInt(String.valueOf(iS.charAt(j)));
                if (sum > n) {
                    break;
                }
            }
            if (sum == n) {
                return i;

            }
            sum = 0;
        }
        return 0;
    }

    private static int findSumOfSmallNum(int k) {
        int sum = 0;

        for (int n = 1; n <= k; n++) {
            sum += findSmallestNum(n);
        }
        return sum;
    }

    private static int finalSum(){
        int sum;
        int sumF = 0;

        int a1 = 1;
        int a2 = 0;

        for (int i = 2; i <= 90; i++) {

            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
            tools.d("We are at: " + i + " || sum: " + sum);
            sumF += findSumOfSmallNum(sum);

        }

        tools.d("sum: " + sumF);
        return sumF % 1000000007;

    }


    public static void main(String[] args) {

        tools.d(finalSum());
//        tools.d(findSumOfSmallNum(89));
    }

}
