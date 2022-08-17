
import  utils.tools;
public class test4 {

    private static double primeCount = 0;
    private static double diagonalCount = 0;
    private static int index = 0;
    private static int numbers = 1;
    private static int mult = 2;
    private static int add = 0;
    private static int diaNum = 0;
    private static int smallestP = 100;


    private static boolean getPercentage(int side) {

        int diagonal;
        double percentage;
        int limit = side * side;

        // 1 - 3 - 5 - 7 - 9
        do {

            if (diaNum == 4) {
                diaNum = 0;
                mult = 4 + add;
                add += 2;
            }

            if (index % mult == 0) {
                diagonal = numbers;
                diaNum++;
                diagonalCount++;
                tools.d("diagonals: " + diagonal);
                if (tools.isItPrime(diagonal)) {
                    primeCount++;
                }
            }

            index++;
            numbers++;
//            tools.d("run");
        } while (numbers <= limit);

        System.out.println("number of diagonals: " + diagonalCount);

        percentage = primeCount / diagonalCount * 100 + 0.5;

        if (percentage < 10) {
            System.out.println("Size: " + side);
            return true;
        }

        if (percentage < smallestP) {
            System.out.println("For size: " + side + " Smallest percentage: " + percentage);
        }

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
        getPercentage(7);
        tools.d("skip");
        getPercentage(9);
        tools.d("skip");
        getPercentage(11);


//        for (int i = 7; i < 121; i = i + 2) {
//            getPercentage(i);
//            tools.d("skip");
//        }

    }
}

