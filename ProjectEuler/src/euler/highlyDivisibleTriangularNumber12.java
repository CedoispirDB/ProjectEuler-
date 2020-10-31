package euler;

import utils.Crono;
import utils.tools;

public class highlyDivisibleTriangularNumber12 {

    public static int findTheQuantityOfDivisors(long x) {
        int count = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static long findTriangleNumbers() {
        Crono c = new Crono();
        long sum = 0;
        long x = 1;
        while (sum <= Long.MAX_VALUE) {

            // Print duration every minute
            if (c.getLastLapDuration() > 60000 ) {
                tools.d("Still working, approximate time elapsed : " + c.elapsedMins() + " mins");
                c.lap();
            }

            sum = sum + x;
            //utils.tools.d("Number: " + sum);
            if (findTheQuantityOfDivisors(sum) >= 500) {
                break;
            }
            x++;

        }
        return sum;

    }

    public static void main(String[] args) {
        tools.d("Number with X divisors: " + findTriangleNumbers());
    }

}





