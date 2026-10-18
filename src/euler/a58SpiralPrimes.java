package euler;


import utils.Tools;

public class a58SpiralPrimes {

    private static double primeCount = 0;
    private static double diagonalCount = 0;
    private static int index = 0;
    private static int numbers = 1;
    private static int mult = 2;
    private static int add = 0;
    private static int diaNum = 0;
    private static int smallestP = 100;
    private static String text = "";

    private static void percentage(int limit) {

        int diagonal = 1;
        int add = 2;
        int cnt = 0;
        double primeDiagonals = 0;
        double totalDiagonals = 1;
        double per = 0;
        int length = 2;

        while(true) {

            diagonal += add;
            cnt++;

            if (cnt == 4) {
                length++;
                totalDiagonals += 4;
                per = (primeDiagonals / totalDiagonals) * 100;
                if (add == 2) {
                    add = 4;
                } else {
                    add += 2;
                }
                cnt = 0;
            }

            if (Tools.isItPrime(diagonal)) {
                primeDiagonals++;
                Tools.d("Prime: " + diagonal);
            }

            // division is wrong


            Tools.d("Number of primes: " + primeDiagonals);
            Tools.d("Total num diagonals: " + totalDiagonals);
            Tools.d("per: " + per);

//            tools.d("length so far: " + (length + 3));
            Tools.d("for " + (length + 3) + " per: " + per);
            if (per < 10 && per != 0) {
                Tools.d("For length: " + (length + 3) + " percentage: " + per);
                break;
            }
            Tools.i("");
        }


    }

    private static boolean getPercentage(int side) {

        double percentage;
        int limit;
        int rotate = 0;

        if (side == 7) {
            limit = 12;
        } else {
            limit = 3;
        }

        // 1 - 3 - 5 - 7 - 9
        do {

            if (diaNum == 4) {
                diaNum = 0;
                mult = 4 + add;
                add += 2;
            }

            diaNum++;
            diagonalCount++;
            if (Tools.isItPrime(numbers)) {
                System.out.println(numbers);
                primeCount++;
            }


            rotate++;
            numbers += mult;
        } while (rotate <= limit);

        Tools.d("primes: " + primeCount);
        Tools.d("diagonals: " + diagonalCount);

        percentage = primeCount / diagonalCount * 100 + 0.5;

        if (percentage < 10) {
            System.out.println(text);
            return true;
        }

        text = text + "For side number: " + side + ", percentage is: " + percentage + "\n";

        return false;
    }

    private static void checkPercentage(int side) {
//        System.out.println("We are at: " + side);


        while (!getPercentage(side)) {
            side += 2;
        }

        System.out.println("done");

    }

    public static void main(String[] args) {
//        tools.d("Start");
//        checkPercentage(7);
//        tools.d("End");
//        getPercentage(7);
//        percentage(10);

        int noOfPrimes = 3;
        int sl = 2;
        int c = 9;

        while( ((double)noOfPrimes)/(2*sl+1) > 0.10){
            sl += 2;
            Tools.d("Length: " + sl);
            for(int i = 0; i < 3; i++){
                c += sl;
                if(Tools.isItPrime(c)) noOfPrimes++;
            }
            c+= sl;
        }

        Tools.d("Num of diagonals: " + (2 * sl + 1));
        Tools.d("Num of primes: " + + noOfPrimes);
        Tools.d("Length: " + sl);
    }
}

