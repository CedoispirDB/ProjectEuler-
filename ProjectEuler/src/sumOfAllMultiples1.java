public class sumOfAllMultiples1 {
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
        tools.l(checkForMultiples(3, 5, 1000));

    }
}