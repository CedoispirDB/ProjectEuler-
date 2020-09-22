import java.math.BigInteger;

public class factorialDigitSum20 {
    public static void sumOfDigits(long x){
        int sum = 0;
        int k = 0;
        BigInteger xFactorial = tools.factorialOfNumberB(x);
        //tools.d("Factorial of " + x + ": " + xFactorial);
        String xFactorialStr = String.valueOf(xFactorial);
        //tools.d(xFactorialStr.length());
        for (int i = 1; i<= xFactorialStr.length(); i++ ){
            String sub = xFactorialStr.substring(k,i);
            sum+= Integer.parseInt(sub);
            k++;
        }
        tools.d(sum);
    }

    public static void main(String[] args) {
        sumOfDigits(100);
    }
}
