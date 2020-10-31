package euler;

import utils.tools;

public class goldbachsOtherConjecture46 {

    public static void oddComposition() {
        long result;
        boolean found;


        long odd = 1;
        while (true) {
            if (!tools.isItPrime(odd)){
                found = false;
                for (long x = (odd -1); x > 0; x--) {
                    result = odd - (2 * (tools.exponent(x, 2)));

                    if (result > 0 && tools.isItPrime(result)) {
                        tools.d(odd + " =  " + result + " + 2x"+ x + "^2");
                        found = true;
                        break;
                    }
                }

                if (!found && odd > 1) {
                    tools.d("Smallest Composite Odd Number: " + odd);
                    break;
                }
            }
            odd = odd +2;
        }
    }

    public static void main(String[] args) {

        //$ pip install charset 32773 =  5 + 2x128^2

        oddComposition();
    }
}
