import utils.mathTools;
import utils.tools;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class test2 {

    private static LinkedList<Double> readFile() {
        LinkedList<Double> primes = new LinkedList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/marcobarreirinhas1/Programs/Java/CodeProjects/ProjectEuler-/ProjectEuler/PrimeNumbers.txt"));
            String line = reader.readLine();
            while (line != null) {
                primes.add(Double.parseDouble(line));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return primes;
    }

    public static void main(String[] args) {
        int limit = 1000000;
//        int limit = 8;

        double ans = 0;
        double ans2 = 0;
        double n0 = 3;
        double d0 = 7;
        BigDecimal checkN = new BigDecimal(-1);
        BigDecimal checkD = new BigDecimal(-1);


        LinkedList<Double> primes = readFile();
//
//      Tests
//        LinkedList<Double> primes = new LinkedList<>();
//        for (int i = 1; i <= 8; i++) {
//            if (tools.isItPrime(i) || i == 1) {
//                primes.add((double) i);
//            }
//        }

//        tools.d("First step done, list size: " + primes.size());
//        primes.forEach(System.out::println);

//        for (double n = 1; n <= limit; n++) {
//            for (double d : primes) {
////            tools.d("d: " + d);
//
//                if (n < d) {
//                    if ((d * n0) > (n * d0) && (checkN.multiply(new BigDecimal(d)).compareTo(checkD.multiply(new BigDecimal(n))) < 0)) {
//                        tools.d("Div: " + n + "/" + d);
//                        tools.d("(d * 3) = " + (d * n0) + " & " + "(n * 7) = " + (n * d0));
////                        tools.d("(n * " + checkD + ") = " + (n * checkD) + " & " + "(d * " + checkN + ") = " + (d * checkN));
////                        tools.d((d * n0) + " > " + (n * d0) + " & " + (d * checkN) + " < " + (n * checkD));
//                        tools.i();
//                        // n/d < 3/7
//                        ans = n;
//                        ans2 = d;
//
//                        checkD = new BigDecimal(d);
//                        checkN = new BigDecimal(n);
//
//
//                    }
//                }
//            }
//
//        }



        tools.i();
        tools.d("First n: " + ans);
        tools.d("First d: " + ans2);
        tools.d("First ans: " + ans);
        tools.i();
//        System.exit(0);

        for (double d = 1; d <= limit; d++) {
//            tools.d("d: " + d);
            for (double n : primes) {
                if (n < d) {
                    tools.d("Div1: " + n + "/" + d);
                    tools.d("Div2: " + d + "/" + n);
                    if ((d * n0) > (n * d0) && (checkN.multiply(new BigDecimal(d)).compareTo(checkD.multiply(new BigDecimal(n))) < 0)) {
                        tools.d("Div: " + n + "/" + d);
//                        tools.d("(d * 3) = " + (d * n0) + " & " + "(n * 7) = " + (n * d0));
//                        tools.d("(n * " + checkD + ") = " + (n * checkD) + " & " + "(d * " + checkN + ") = " + (d * checkN));
//                        tools.d((d * n0) + " > " + (n * d0) + " & " + (d * checkN) + " < " + (n * checkD));
//                        tools.i();
                        // n/d < 3/7
                        ans = n;
                        ans2 = d;
//
                        checkD = new BigDecimal(d);
                        checkN = new BigDecimal(n);
                    }
                }
            }
        }
        tools.i();
        tools.d("Second n: " + ans);
        tools.d("Second d: " + ans2);
        tools.d("Second ans: " + ans);
    }

}
