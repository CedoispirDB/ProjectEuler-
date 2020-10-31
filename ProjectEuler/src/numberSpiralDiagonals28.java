public class numberSpiralDiagonals28 {
    private static int sumOfDiagonals(int limit){
        int  sum = 1;
        for(int i = 3; i <= limit; i = i + 2){
            int sqr = tools.exponent(i, 2);
            sum = sum + sqr + (sqr - (i - 1)) + (sqr - (i - 1)*2) + (sqr - (i - 1)*3);
            tools.d("Size = " + i + " , sum = "+ sum);

        }

        return sum;
    }

    public static void main(String[] args) {
        sumOfDiagonals(1001);
    }
}
