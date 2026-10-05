import utils.mathTools;
import utils.tools;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
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
                    "/Users/marcobarreirinhas1/Programs/Java/CodeProjects/ProjectEuler-/ProjectEuler/PrimeNumbers2.txt"));
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

        int m = 0;
        for (double d = limit ; d >= 0; d--) {
//            tools.d("d: " + d);
            m ++;
            if (m == 50) {
                System.exit(0);
            }
            for (double n : primes) {
                if (n < d) {
                    tools.i();
//                  tools.d("Div1: " + n + "/" + d);
                    tools.d("Div2: " + n + "/" + d);
//                  tools.d("Result1: " +  (n / d));
                    if ((n / d) < (3.0 / 7.0)) {
                        tools.d("Result2: " + n / d + "*Less");
                    } else {
                        tools.d("Result2: " + n / d);
                    }

                    tools.d("CheckN: " + checkN + ", CheckD: " + checkD);

                    if (((d * n0) > (n * d0) && (checkN.multiply(new BigDecimal(d)).compareTo(checkD.multiply(new BigDecimal(n))) < 0))) {
                        tools.d("Div: " + n + "/" + d + ", previous: " + checkN.divide(checkD, MathContext.DECIMAL32));

                        ans = n;
                        ans2 = d;
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

//2021-03-17 13:05:42.337 : First n: 428564.0
//2021-03-17 13:05:42.338 : First d: 999983.0
//2021-03-17 13:05:42.338 : First ans: 428564.0