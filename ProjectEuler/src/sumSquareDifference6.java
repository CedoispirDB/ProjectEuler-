public class sumSquareDifference6 {
    public static void p() {
        long sumOfNumbers = 0;
        long sumOfSquares = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfNumbers += i;
            sumOfSquares += Math.pow(i,2);
            //tools.d(x);
        }
        long squareSumOfNumber = (long) Math.pow(sumOfNumbers,2);
        long difference = squareSumOfNumber - sumOfSquares;
        tools.d(difference);

    }

    public static void main(String[] args) {
        p();
    }
}
