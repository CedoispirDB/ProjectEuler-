package utils;

public class mathTools {

    //Function to simplify numbers
    public static String simplifyNum(int n, int d) {
        int min = Math.min(n, d);
        if (n % d == 0){
            return String.valueOf(n / d);

        }        if (n % min == 0 && d % min == 0){
            n = n / min;
            d = d /min;
        }
        if (n == 1 || d == 1){
            return n +"/" + d;

        }        return simplifyNum(n, d);
    }

    //Function to take the square get a int as parameter
    public static int square(int x ){
        return (int) Math.sqrt(x);

    }

    public static void main(String[] args) {
        tools.d(simplifyNum(3, 12));
    }
}
