public class factorialDigitSum {
    public static void sumOfDigits(long x){
        int sum = 0;
        long xFactorial = tools.factorialOfNumber(x);
        tools.d(xFactorial);
        String xFactorialStr = String.valueOf(xFactorial);
        for(int i = 0; i<xFactorialStr.length(); i++){
             sum += xFactorialStr.charAt(i);
        }
        tools.d(sum);
    }

    public static void main(String[] args) {
        sumOfDigits(100);
    }
}
