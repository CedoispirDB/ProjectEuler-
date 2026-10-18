package euler;

import utils.Tools;

public class a46goldbachsOtherConjecture {

    public static void oddComposition() {
        long result;
        boolean found;


        long odd = 1;
        while (true) {
            if (!Tools.isItPrime(odd)){
                found = false;
                for (long x = (odd -1); x > 0; x--) {
                    result = odd - (2 * (Tools.exponent(x, 2)));

                    if (result > 0 && Tools.isItPrime(result)) {
                        Tools.d(odd + " =  " + result + " + 2x"+ x + "^2");
                        found = true;
                        break;
                    }
                }

                if (!found && odd > 1) {
                    Tools.d("Smallest Composite Odd Number: " + odd);
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
