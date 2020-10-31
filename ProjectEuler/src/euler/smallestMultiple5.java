package euler;

public class smallestMultiple5 {
    public static void l() {
        // Loop and get max possible result
        long maxPossibleResult = 1;
        for (int i = 1; i<=10; i++){
            maxPossibleResult = maxPossibleResult*i;
        }

        tools.d("Max Possible Result: "+ maxPossibleResult);

        // Loop from minGuess to maxPossibleResult
        long minGuess = 10*9;
        long minResult=0;
        for (long n = minGuess; n < maxPossibleResult; n++) {

            // Eliminate unfit numbers
            if (n % 2 == 0) {

                boolean found = true;

                for (int x = 1; x <= 10; x++) {
                    if (!(n % x == 0)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    minResult = n;
                    break;
                }
            }
        }
        tools.d("The smallest multiple is: " + (minResult >0 ? minResult : maxPossibleResult) );
    }


    public static void main(String[] args) {
        l();

    }

}
