package euler;

import java.math.BigInteger;

public class a16powerDigitSum {
    public static long digitsSums(int number, int power) {
        long sum = 0;
        BigInteger numberB = BigInteger.valueOf(number);
        BigInteger numberPower = numberB.pow(power);
        //utils.tools.d(number + " to the " + power + "th power " + "is : " + numberPower );
        String numbers = String.valueOf(numberPower);
        for (int i = 0; i < numbers.length(); i++){
            sum += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        //utils.tools.d("The sum is " + sum);
        return sum;


    }

    public static void main(String[] args) {
        digitsSums(2,1000);
    }
}
