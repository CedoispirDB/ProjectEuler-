
import java.math.BigInteger;

public class powerDigitSum16 {
    public static long digitsSums(int number, int power) {
        long sum = 0;
        BigInteger numberB = BigInteger.valueOf(number);
        BigInteger numberPower = numberB.pow(power);
        //tools.d(number + " to the " + power + "th power " + "is : " + numberPower );
        String numbers = String.valueOf(numberPower);
        for (int i = 0; i < numbers.length(); i++){
            sum += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        //tools.d("The sum is " + sum);
        return sum;


    }

    public static void main(String[] args) {
        digitsSums(2,1000);
    }
}
