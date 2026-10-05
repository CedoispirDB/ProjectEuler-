package euler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import utils.tools;


public class a26reciprocalCycles {

    //    1 -> numerator
    //    Find d -> 1/d

    private static void findPeriodicNum() {

        List<String> v = new LinkedList<>();
        BigDecimal bg1 = new BigDecimal("1");
        BigDecimal bg2, bg3;
        String decimals, newDecimal;
        String godKnows;
        String dust;

        int endNum = 0;
        boolean infinity;
        int lastOccurrence;
        int check = 0;

        for (int d = 1; d <= 1000; d++) {
            infinity = true;
            // Only numbers with remainder
            if (1000 % d != 0) {
                bg2 = new BigDecimal(d);
                bg3 = bg1.divide(bg2, 2000, RoundingMode.HALF_EVEN);

                decimals = String.valueOf(bg3).substring(4);
                decimals = decimals.substring(0, decimals.length() - 2);
                //decimals = decimals
                //decimals = "001267427122940430925221799746514575411913814955640050697084917617237008871989860583016476552598225602027883396704689480354879594423320659062103929024081115335868187579214195183776932826362484157160963244613434727503168567807351077313054499366286438529784537389100126742712294043092522179974651457541";


                godKnows = decimals.substring(0, 6);
                if (!decimals.substring(25, 35).equals(decimals.substring(35, 45))) {
                    for (int l = 1; l <= decimals.length(); l++) {
                        dust = decimals.substring(0, l);
                        if (godKnows.equals(dust)) {
                            //utils.tools.d("Is here." + " The number is " + d);
                            infinity = false;
                            break;
                        }
                    }
                }

                if (!infinity) {

                    //utils.tools.d("The number " + d + " decimals in " + decimals.substring(0, 6) + "  and it is not infinity");
                    //utils.tools.d(decimals);
                    lastOccurrence = decimals.lastIndexOf(decimals.substring(0, 5));
                    //utils.tools.d("Last occurrence: " + lastOccurrence);
                    //utils.tools.d("Original:" + decimals);
                    newDecimal = decimals.substring(0, lastOccurrence);
                    //utils.tools.d("Reduced:" + decimals);
                    lastOccurrence = newDecimal.lastIndexOf(decimals.substring(0, 5));

                    if (newDecimal.length() - lastOccurrence > check) {
                        check = newDecimal.length() - lastOccurrence;
                        endNum = d;
                        tools.d("Larger size detected is " + check + " from 1/" + endNum);
                    }
                }
            }
        }


        tools.d("Number of decimals digits with longest period: " + endNum + " with " + check + "numbers ");
    }

    public static void main(String[] args) {
        findPeriodicNum();
    }
}