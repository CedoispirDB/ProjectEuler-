package euler;
import utils.tools;


public class a1sumOfAllMultiples {
    public static int checkForMultiples(int x, int y, int w) {
        int sum = 0;
        for (int i = 0; i < w; i++) {
            if (i % x == 0 || i % y == 0) {
                //System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        tools.i(checkForMultiples(3, 5, 1000));
//        System.out.println(checkForMultiples(3, 5, 1000));
    }
}





//