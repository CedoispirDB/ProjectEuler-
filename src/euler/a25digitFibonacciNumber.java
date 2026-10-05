package euler;
import utils.tools;

public class a25digitFibonacciNumber {

    private static String sumOfStrings(String a, String b, int remainder, String result) {
        int k;
        int p;
        int sum;
        int r;
        String sumStr;
        String newB;
        String newA;

        if (a.equals("") && b.equals("")) {
            return result;
        }

        if (a.equals("")) {
            k = 0;
            newA = "";
        } else {
            k = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1)));
            newA = a.substring(0, a.length() - 1);
        }

        if (b.equals("")) {
            p = 0;
            newB = "";
        } else {
            p = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1)));
            newB = b.substring(0, b.length() - 1);

        }

        sum = k + p + remainder;
        sumStr = String.valueOf(sum);

        if (sumStr.length() == 1 || sumStr.length() == 0) {
            r = 0;
        } else {
            r = Integer.parseInt(sumStr.substring(0, sumStr.length() - 1));
        }

        if (newA.equals("") && newB.equals("") && r > 0) {
            return String.valueOf(r) + sumStr.charAt(sumStr.length() - 1) + result;

        }


        return sumOfStrings(newA, newB, r, (sumStr.charAt(sumStr.length() - 1) + result));
    }

    public static long fibonacciSequence() {

        int count = 1;
        String strSum;
        String a1str = "1";
        String a2str = "";
        //utils.tools.d("\n" + "Fibonacci sequence: " + "\n");
        do {
           // utils.tools.d("\n a1: " + a1str + " \n a2: " + a2str + "\n sum: " + strSum + "\n\n" );
            //utils.tools.d(count + ": " + strSum + "\n");

            strSum = sumOfStrings(a1str, a2str, 0, "");
            a1str = a2str;
            a2str = strSum;


            //utils.tools.d("\n" + "Sum length: " + String.valueOf(strSum).length() + "\n" + "sum:" + strSum + "\n");
            tools.d(count + "-) " + strSum + "\n");
            //strSum.length() <= 1000
            count++;
        } while (strSum.length() < 1000);

        return count - 1;
    }

    public static void main(String[] args) {
        tools.d(fibonacciSequence());

    }
}
