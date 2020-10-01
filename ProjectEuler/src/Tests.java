import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tests {

    //Give the day of the week according to the date
    public static String getDayStringOld(Date date, Locale locale) {
        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        return formatter.format(date);
    }

    //Months with 30 31 28 29
    //Years divisible by 4
    //Years divisible by 100 Just are leap year if they are divisible by 400

    //Count the number of sundays
    //Count from January 1st 1900 to the impute date
    public static int numberOfSundays(int year, int month, int day) {
        int yf;
        int add;
        int sub;

        int numberOfSundays = 0;
        for (int y = 1; y <= year - 1900; y++) {
            yf = y + 1900;
            boolean yearDiv4 = yf % 4 == 0;
            boolean centuryDiv = yf % 100 == 0 && yf % 400 == 0;
            boolean leapYear = yearDiv4 && centuryDiv;

            for (int m = 0; m <= month - 1; m++) {
                if (m == 0 || m == 2 || m == 4 || m == 6 || m == 7 || m == 8 || m == 9 || m == 11) {
                    add = 1;
                    sub = 0;
                } else if (m == 1) {
                    if (leapYear) {
                        sub = 1;
                    } else {
                        sub = 2;
                    }
                    add = 0;
                } else {
                    add = 0;
                    sub = 0;
                }

                for (int d = 1; d <= day + add - sub; d++) {
                    Date date = new Date(y, m, d);
                    String k = getDayStringOld(date, Locale.US);

                    if (k.equals("Sunday") && d == 1) {
                        numberOfSundays++;
                    }

                }
            }
        }

        return numberOfSundays;
    }


    public static void main(String[] args) {

        tools.d("The number of sundays is: " + numberOfSundays(2000,12,30));
    }
}