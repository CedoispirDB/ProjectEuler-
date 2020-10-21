public class EvenFibonacciNumbers2 {
    public static int fibonacciSequence() {
        int a1 = 1;
        int a2 = 0;
        int evenSum = 0;
        int sum=0;
        while (sum <= 4000000) {
            sum = a1 + a2;
            // Compare module to confirm even number
            if (sum % 2 == 0) {
                evenSum += sum;
            }
            a1 = a2;
            a2 = sum;

        }

        return evenSum;
    }

    public static void main(String[] args) {
        tools.i("The sum is "+ fibonacciSequence());
    }

}