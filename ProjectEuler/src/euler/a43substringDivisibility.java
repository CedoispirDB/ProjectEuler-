package euler;

import utils.tools;


public class a43substringDivisibility {

    public static boolean checkIfPandigital(String number) {
        boolean isPan = false;
        if (number.length() != 10) {
            return false;
        }
        for (int i = 0; i <= 9; i++) {
            if (number.contains(String.valueOf(i))) {
                isPan = true;
            } else {
                isPan = false;
                break;
            }
        }
        return isPan;
    }


    //    d2d3d4=406 is divisible by 2
    //    d3d4d5=063 is divisible by 3
    //    d4d5d6=635 is divisible by 5
    //    d5d6d7=357 is divisible by 7
    //    d6d7d8=572 is divisible by 11
    //    d7d8d9=728 is divisible by 13
    //    d8d9d10=289 is divisible by 17
    //Divide values of the substrings of a number
    private static boolean substringDiv(long num) {
        String numS = String.valueOf(num);
        StringBuilder newString = new StringBuilder(" ");
        int count = 0;
        int add = 0;
        boolean ok = true;
        do {
            newString.setLength(0);
            for (int i = 1 + add; i <= 3 + add; i++) {
                newString.append(numS.charAt(i));
            }
            if (!(Integer.parseInt(String.valueOf(newString)) % 2 == 0) && count == 0) {
                ok = false;
                break;
            }

            if (!(Integer.parseInt(String.valueOf(newString)) % 3 == 0) && count == 1) {
                ok = false;
                break;
            }

            if (!(Integer.parseInt(String.valueOf(newString)) % 5 == 0) && count == 2) {
                ok = false;
                break;
            }

            if (!(Integer.parseInt(String.valueOf(newString)) % 7 == 0) && count == 3) {
                ok = false;
                break;
            }

            if (!(Integer.parseInt(String.valueOf(newString)) % 11 == 0) && count == 4) {
                ok = false;
                break;
            }

            if (!(Integer.parseInt(String.valueOf(newString)) % 13 == 0) && count == 5) {
                ok = false;
                break;
            }

            if (!(Integer.parseInt(String.valueOf(newString)) % 17 == 0) && count == 6) {
                ok = false;
                break;
            }


            add++;
            count++;
        } while (count <= 6);
        return ok;
    }

    //Sum all numbers with that property
    private static long sumOfNum() {
        long sum = 0;
        for (long i = 1000000000; i <= 9000000000L; i++) {
            if (i % 1000000000L == 0) {
                tools.d("We are at: " + i + " || with sum:" + sum);

            }
            if (checkIfPandigital(String.valueOf(i)) && substringDiv(i)) {
                sum += i;
                tools.d("i: " + i + " || sum: " + sum);

            }
        }
        return sum;
    }

    // i: 1406357289 sum: 1406357289
// i: 1430952867 sum: 2837310156
// i: 1460357289 sum: 4297667445
    public static void main(String[] args) {
        tools.d(sumOfNum());
        //1406357289
//        for (long i = 4000000000L; i <= 5000000000L; i++) {
//
//            tools.d("For: " + i +": " + substringDiv((int) i ));
//
//
//        }

        //4195091684
//        tools.d( substringDiv((int)  4 195 091 685L));
        //tools.d(checkIfPandigital("4000000000"));
    }


}
