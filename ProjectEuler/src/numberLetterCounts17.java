import java.awt.image.TileObserver;
import java.util.HashMap;
import java.util.Map;

public class numberLetterCounts17 {

    public static void counter(int n) {

        Map<Integer, String> m = new HashMap<>();

        m.put(0, "and");
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "three");
        m.put(4, "four");
        m.put(5, "five");
        m.put(6, "six");
        m.put(7, "seven");
        m.put(8, "eight");
        m.put(9, "nine");
        m.put(10, "ten");
        m.put(11, "eleven");
        m.put(12, "twelve");
        m.put(13, "thirteen");
        m.put(14, "fourteen");
        m.put(15, "fifteen");
        m.put(16, "sixteen");
        m.put(17, "seventeen");
        m.put(18, "eighteen");
        m.put(19, "nineteen");
        m.put(20, "twenty");
        m.put(30, "thirty");
        m.put(40, "forty");
        m.put(50, "fifty");
        m.put(60, "sixty");
        m.put(70, "seventy");
        m.put(80, "eighty");
        m.put(90, "ninety");
        m.put(100, "hundred");
        m.put(1000, "thousand");

        int count = 1;
        int addition = 0;
        long k = n / 1000;
        long lettersInUnits = 0;
        long lettersInUnits2 = 0;
        long lettersInTenths = 0;
        long lettersInHundreds = 0;
        long lettersInTeens = 0;
        long lettersInThousands = 0;
        long lettersInAnd = 0;
        long totalLetters;


        do {
            for (int i = 1; i <= 100; i++) {
                String units2 = m.get(count);
                lettersInUnits2 += units2.length();
            }
            count++;
        }while(count <= 9 * k);

        tools.d("UnitsInHundreds: " + lettersInUnits2);


        //Count how many letters there is in all units for the interval 1-n
        do {
            for (int i = 1; i <= 9; i++) {
                String units = m.get(i);
                lettersInUnits += units.length();
            }

        } while (lettersInUnits != 3240 * k);

        tools.d("Units: " + lettersInUnits);

        //Count how many letters there is in all "teens" numbers for the interval 1-n
        do {
            for (int b = 10; b <= 19; b++) {
                String teens = m.get(b);
                lettersInTeens += teens.length();
            }

        } while (lettersInTeens != 700);

        tools.d("Teens: " + lettersInTeens);
        tools.d("Sum of 1-19: " + lettersInUnits+lettersInTeens);

        //Count how many letters there is in all the tenths for the interval 1-n
        do {
            for (int t = 20; t <= 90; t = t + 10) {
                String tenths = m.get(t);
                for (int u = 0; u <= 9; u++) {
                    lettersInTenths += tenths.length();

                }
            }

        } while (lettersInTenths != 4600 * k);

        tools.d("Tenths: " + lettersInTenths);

        //Count how many letters there is in all the hundreds for the interval 1-n
        do {

            String hundreds = m.get(100);
            for (int u = 100; u < 1000; u++) {
                lettersInHundreds += hundreds.length();
            }


        } while (lettersInHundreds != 6300 * k);

        tools.d("Hundreds: " + lettersInHundreds);

        //Count how many letters there is in all the thousands for the interval 1-n
        if (n > 1000) {
            do {

                String thousands = m.get(1000);
                for (int u = 1000; u < 1000000; u++) {
                    lettersInThousands += thousands.length();

                }


            } while (lettersInThousands != 72000 * k);
        } else {
            addition = 11;
        }

        tools.d("Thousands: " + lettersInThousands);

        //Count how many letters there is in all the and's for the interval 1-n
        do {
            String and = m.get(0);
            lettersInAnd += and.length();


        } while (lettersInAnd != 2862 * k);

        tools.d("And's: " + lettersInAnd);

        long testSum = lettersInUnits + lettersInUnits2;
        tools.d(testSum);
        //tools.d(lettersInUnits);
        totalLetters = lettersInUnits + lettersInTeens + lettersInTenths + lettersInHundreds + lettersInAnd + addition;

        tools.d("Total letters: " + totalLetters);

    }

    public static void main(String[] args) {
        counter(1000);
    }

}
