package euler;
import utils.tools;

public class a34digitFactorials {
    private static int sum() {
        int sum;
        int totalSum = 0;
        int numFac;
        int x;
        String digitStr;

        for (int digit = 10; digit <= 362880; digit++) {
            sum = 0;
            digitStr = String.valueOf(digit);
            for (int i = 0; i < digitStr.length(); i++) {
                x = Integer.parseInt(String.valueOf(digitStr.charAt(i)));
                numFac = tools.factorialOfNumber(x);
                sum += numFac;
                //utils.tools.d("The sum for " + digit + " is " + sum + " (" + numFac + ")");
                if (sum == digit){
                    totalSum += digit;
                }
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        tools.d("Total sum is: " + sum());
    }
}
