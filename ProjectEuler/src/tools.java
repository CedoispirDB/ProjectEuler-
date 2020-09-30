import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public class tools {

    //Formatting a number
    public static void format(double in) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println(decimalFormat.format(in));
    }

    //Print value with date and time
    public static void d(Object x) {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " - " + x);
    }

    //Print value
    public static void l(Object x) {
        System.out.println(x);
    }

    //Find if a number is prime or not
    public static boolean isItPrime(long x) {
        boolean prime = false;
        if (sumOfDivisors(x) == 1) {
            prime = true;
        }
        return prime;
    }

    //Find the factorial of a number - returns A BigInteger
    public static BigInteger factorialOfNumberB(Object n) {
        int x = Integer.parseInt((String) n);
        BigInteger factorial = BigInteger.valueOf(1);
        for (long i = 1; i <= x; i++) {
            BigInteger ib = BigInteger.valueOf(i);
            factorial = factorial.multiply(ib);
            //tools.d(factorial);
        }
        //tools.d("y: " + factorial);
        return factorial;

    }

    //Find the factorial of a number - returns a long
    public static long factorialOfNumber(Object n) {
        int x = Integer.parseInt((String) n);
        long factorial = 1;
        for (long i = 1; i <= x; i++) {
            factorial = factorial * i;
            //tools.d(factorial);
        }
        //tools.d("y: " + factorial);
        return factorial;

    }

    //Find the sum of all the divisors of a number
    public static int sumOfDivisors(long x) {
        int sumOfDivisors = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                sumOfDivisors += i;
            }
        }
        return sumOfDivisors;
    }

    //Get information from a file
    public static String readFromFile() {

        String path = "ProjectEuler-/names.txt";
        String content = "";
        try {

            // default StandardCharsets.UTF_8
            content = Files.readString(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;

    }

    public static void main(String[] args) {
    }
}




