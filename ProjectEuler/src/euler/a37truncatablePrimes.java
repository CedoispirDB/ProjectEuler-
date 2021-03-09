package euler;
import utils.tools;


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
            if (tools.isItPrime(i)) {
                prime = String.valueOf(i);
                //utils.tools.d("From the left: ");
                for (int k = 0; k < prime.length(); k++) {
                    //utils.tools.d("to the number: " + i + " the charts are: " + prime.substring(k));
                    if (tools.isItPrime(Integer.parseInt(prime.substring(k)))) {
                        isTL = true;
                    } else {
                        isTL = false;
                        break;
                    }
                }
                //utils.tools.d("From the right: ");
                for (int h = prime.length() - 1; h > 0; h--) {
                    //utils.tools.d("to the number: " + i + " the charts are: " + prime.substring(0, h));
                    if (tools.isItPrime(Integer.parseInt(prime.substring(0, h)))) {
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
                tools.d("Sum is: " + sum + " to the number: " + i);
            }
        }
        //utils.tools.l("");
        tools.d("The final sum is: " + sum + " with " + count + " numbers");
        return sum;
    }

    public static void main(String[] args) {
        sumOfTP();
    }
}

//739397
