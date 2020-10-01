import java.math.BigInteger;

public class factorialDigitSum20 {
    public static void sumOfDigits(long p){
        int sum = 0;
        int k = 0;
        BigInteger x = BigInteger.valueOf(p);
        BigInteger xFactorial = tools.factorialOfNumberB(Long.parseLong(String.valueOf(x)));
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
