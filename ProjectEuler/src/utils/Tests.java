package utils;

public class Tests {

//    private static String newString = "";
//
//    private static String sumOfStrings(String a, String b, int remainder) {
//        int k;
//        int p;
//        int sum;
//        int r;
//        String sumStr;
//        String newB;
//        String newA;
//        String result;
//
//        if (a.equals("") && b.equals("")) {
//            result = newString;
//            newString = "";
//            return result;
//        }
//
//        if (a.equals("")) {
//            k = 0;
//            newA = "";
//        } else {
//            k = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1)));
//            newA = a.substring(0, a.length() - 1);
//        }
//
//        if (b.equals("")) {
//            p = 0;
//            newB = "";
//        } else {
//            p = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1)));
//            newB = b.substring(0, b.length() - 1);
//
//        }
//
//        sum = k + p + remainder;
//        sumStr = String.valueOf(sum);
//
//        if (sumStr.length() == 1 || sumStr.length() == 0) {
//            r = 0;
//        } else {
//            r = Integer.parseInt(sumStr.substring(0, sumStr.length() - 1));
//        }
//
//        if (newA.equals("") && newB.equals("") && r > 0) {
//
//            result = newString;
//            newString = "";
//            return String.valueOf(r) + sumStr.charAt(sumStr.length() - 1) + result;
//
//        }
//
//        newString = sumStr.charAt(sumStr.length() - 1) + newString;
//
//
//        return sumOfStrings(newA, newB, r);
//    }


    private static String sumOfStrings(String a, String b, int remainder, String result) {
        int k;
        int p;
        int sum;
        int r;
        String sumStr;
        String newB;
        String newA;

        if (a.equals("") && b.equals("")) {
            return result;
        }

        if (a.equals("")) {
            k = 0;
            newA = "";
        } else {
            k = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1)));
            newA = a.substring(0, a.length() - 1);
        }

        if (b.equals("")) {
            p = 0;
            newB = "";
        } else {
            p = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1)));
            newB = b.substring(0, b.length() - 1);

        }

        sum = k + p + remainder;
        sumStr = String.valueOf(sum);

        if (sumStr.length() == 1 || sumStr.length() == 0) {
            r = 0;
        } else {
            r = Integer.parseInt(sumStr.substring(0, sumStr.length() - 1));
        }

        if (newA.equals("") && newB.equals("") && r > 0) {
            return String.valueOf(r) + sumStr.charAt(sumStr.length() - 1) + result;

        }



        return sumOfStrings(newA, newB, r, (sumStr.charAt(sumStr.length() - 1) + result));
    }



    public static void fibonacciSequence() {
        int count = 1;
        boolean found = false;
        String strSum = "1";
        String a1str = String.valueOf(1);
        String a2str = String.valueOf(0);

        do {
            count++;
            tools.d("\n" + "a1: " + a1str + "\n" + "a2: " + a2str + "\n" + "count: " + count + "\n" + "sum before: " + strSum);
            strSum = sumOfStrings(a1str, a2str, 0, "");
            tools.i("Sum after " + strSum + "\n");
            a1str = a2str;
            a2str = strSum;


            if (strSum.length() >= 1000) {
                found = true;
            }

        } while (!found);


    }





    public static void main(String[] args) {
        //fibonacciSequence();
        //utils.tools.i("\n");
       fibonacciSequence();
    }
}


//1811299057

