package euler;
import utils.Tools;


public class a37truncatablePrimes {

    private static int sumOfTP() {
        String prime;
        int sum = 0;
        boolean isTR;
        boolean isTL;
        int count = 0;
        for (int i = 8; i <= 1000000; i++) {
            isTR = false;
            isTL = false;
            if (Tools.isItPrime(i)) {
                prime = String.valueOf(i);
                //utils.tools.d("From the left: ");
                for (int k = 0; k < prime.length(); k++) {
                    //utils.tools.d("to the number: " + i + " the charts are: " + prime.substring(k));
                    if (Tools.isItPrime(Integer.parseInt(prime.substring(k)))) {
                        isTL = true;
                    } else {
                        isTL = false;
                        break;
                    }
                }
                //utils.tools.d("From the right: ");
                for (int h = prime.length() - 1; h > 0; h--) {
                    //utils.tools.d("to the number: " + i + " the charts are: " + prime.substring(0, h));
                    if (Tools.isItPrime(Integer.parseInt(prime.substring(0, h)))) {
                        isTR = true;
                    } else {
                        isTR = false;
                        break;
                    }
                }
            }
//            utils.tools.d("Sum is: " + sum + " to the number: " + i);
//            utils.tools.d("isTR: " + isTR);
//            utils.tools.d("isTL: " + isTL);

            if (isTR && isTL) {
                sum += i;
                count++;
                Tools.d("Sum is: " + sum + " to the number: " + i);
            }
        }
        //utils.tools.l("");
        Tools.d("The final sum is: " + sum + " with " + count + " numbers");
        return sum;
    }

    public static void main(String[] args) {
        sumOfTP();
    }
}

//739397
