package euler;

public class specialPythagoreanTriplet9 {
    public static void pythagoreanTheorem() {
        boolean potato = false;
        int a = 0;
        int b = 0;
        int c = 0;
        int x;
        double y;
        //Give a value to "a"` to be tested

        for (int k = 1; k < 1000; k++) {
            if (potato) {
                break;
            }
            a = k;
            //Give a value to "b" to be tested

            for (int i = 1; i < 1000; i++) {
                if (potato) {
                    break;
                }
                b = i;
                //Give a value to "c" to be tested

                for (int l = 1; l < 1000; l++) {
                    c = l;
                    x = a + b + c;
                    y = Math.pow(a, 2) + Math.pow(b, 2);

                    /*Test if the sum of them is 1000
                     && if the sum of the squared of a and b is equal the square of c*/

                    if (x == 1000 && y == Math.pow(c, 2)) {

                        potato = true;

                        tools.d("a: " + a);
                        tools.d("b: " + b);
                        tools.d("c: " + c);
                        break;

                    }
                }
            }
        }
        //utils.tools.d("a: " + a);
        //utils.tools.d("b: " + b);
        //utils.tools.d("c: " + c);

        //Get the product of a, b and c

        int product = a * b * c;
        tools.d(product);
    }

    public static void main(String[] args) {
        pythagoreanTheorem();
    }

}
