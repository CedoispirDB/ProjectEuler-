public class countingSundays19 {
    public static int sundayDays() {
        int day;
        int month;
        int year = 1900;
        int count = 0;
        int sundays = 0;
        int x;

        // has to be divisible by 4, but divisible by 100 are not unless divisible by 400.
        do {
            //Is a leap year
            boolean yearDiv4 = (year % 4 == 0);
            //is not a leap year
            boolean centuryDiv400 = (year % 100 == 0 && year % 400 != 0);
            boolean leapYear = yearDiv4 && !centuryDiv400;
            if (leapYear) {
                x = 1;
            } else {
                x = 0;
            }
            month = 1;
            do {
                day = 0;
                if (month == 8) {
                    do {
                        if (count % 7 == 0 && day == 1) {
                            sundays++;
                        }
                        day++;
                        count++;

                    } while (day <= 31);


                } else if (month == 2) {
                    do {
                        if (count % 7 == 0 && day == 1) {
                            sundays++;

                        }
                        day++;
                        count++;


                    } while (day <= 28 + x);

                } else {
                    if (tools.isItPrime(month)) {
                        do {
                            if (count % 7 == 0 && day == 1) {
                                sundays++;
                            }
                            day++;
                            count++;

                        } while (day <= 31);
                    } else {
                        do {
                            if (count % 7 == 0 && day == 1) {
                                sundays++;

                            }
                            day++;
                            count++;

                        } while (day <= 30);
                    }
                }
                tools.d("count:" + count);
                month++;
            } while (month <= 12);
            year++;
        } while (year <= 2000);

        return sundays;
    }

    public static void main(String[] args) {
        tools.d(sundayDays());
    }
}
