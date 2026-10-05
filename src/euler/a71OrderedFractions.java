package euler;

import utils.tools;
import utils.mathTools;

import java.util.LinkedList;


public class a71OrderedFractions {

    private static void findOrder() {
        LinkedList<Double> numerators = new LinkedList<>();
        LinkedList<Double> denominators = new LinkedList<>();

        int l = 1000000;

        double x = 3.0/7.0;
        double quotient = 0;
        double ans = 0;

        for (double d = 1; d <= l; d++) {
            for (double n = 1; n < d; n++) {
                if (tools.isItPrime((int) d)|| tools.isItPrime((int) n)) {
                    //Is reduced proper fraction
                    if ((n / d) < x) {
                        if ((n /d) > quotient){
                            quotient = (n / d);
                            ans = n;
                        }
                    }


                }

            }

        }
        tools.d(ans);
    }

    public static void main(String[] args) {
        findOrder();
    }

}
