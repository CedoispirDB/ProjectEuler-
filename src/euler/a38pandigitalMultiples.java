package euler;

import utils.tools;

import static euler.a32pandigitalProducts.checkIfPandigital;

public class a38pandigitalMultiples {
    private static int product() {
        int a1;
        int a2;
        String c;
        int check = 0;
        int result = 0;
        int ci;
        for (int i = 100; i <= 100000; i++) {
            for (int j = 1; j <= 100000; j++) {
                a1 = i * j;
                a2 = i * (j + 1);
                c = String.valueOf(a1) + a2;
                if (checkIfPandigital(c)) {
                    ci = Integer.parseInt(c);
                    if (ci > check) {
                        result = ci;
                        check = ci;
                    }
                }else {
                    break;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        tools.d(product());
    }
}
