package euler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class a89RomanNumerals {

    final private static HashMap<String, Integer> rn = new HashMap<>();
    final private static HashMap<Integer, String> decToRom = new HashMap<>();
    final private static int[] decimalsOrder = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    private static void populateMap() {
        rn.put("I", 1);

        rn.put("IV", 4);
        rn.put("V", 5);

        rn.put("IX", 9);
        rn.put("X", 10);

        rn.put("XL", 40);
        rn.put("L", 50);

        rn.put("XC", 90);
        rn.put("C", 100);

        rn.put("CD", 400);
        rn.put("D", 500);

        rn.put("CM", 900);
        rn.put("M", 1000);

        Set<Map.Entry<String, Integer>> entrySet = rn.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            String k = entry.getKey();
            Integer v = entry.getValue();

            decToRom.put(v, k);
        }

    }

    // Create roman number and return num of characters
    public static int processDecimalNumber(int decimal) {
        String result = "";
        int r_decimal = decimal;
        int i = 0;

        while (r_decimal > 0 && i < decimalsOrder.length) {

            if(r_decimal >= 1000) {
                result += "M";
                r_decimal -= 1000;
                continue;
            }

            int check = decimalsOrder[i];
            // System.out.println("Check: " + String.valueOf(check) + "\nr_decimal(1): " + String.valueOf(r_decimal));
         
            if (check == r_decimal) {
                result += decToRom.get(check);
                r_decimal -= check;
                i = 0;
            } else if(check > r_decimal) {
                int prev = decimalsOrder[i - 1];
                result += decToRom.get(prev);
                r_decimal = Math.abs(r_decimal - prev);
                i = 0;
            }

            i++;

            // System.out.println("r_decimal(2): " + r_decimal);
        }
        
        System.out.println(result);
        return result.length();
    }

    public static void main(String[] args) throws IOException {
        populateMap();

        System.out.println(rn);
        System.out.println(decToRom);

        Path path = Path.of(System.getProperty("user.home"), "Desktop", "roman.txt");

        int finalDiff = 0;

        try (var lines = Files.lines(path)) {
            for (String line : lines.toList()) {
                System.out.print("Line: " + line);

                int sum = 0;

                int i = 0;
                while (i < line.length()) {
                    String roman = String.valueOf(line.charAt(i));
                    int decimal = rn.get(roman);
                    int decimalNext = 0;

                    if (i < line.length() - 1) {
                        String romanNext = String.valueOf(line.charAt(i + 1));
                        decimalNext = rn.get(romanNext);
                        if (decimalNext > decimal) {
                            decimal = decimalNext - decimal;
                            i++;
                        } else {
                            decimalNext = 0;
                        }
                    }

                    sum += decimal;

                    i++;
                }

                System.out.print(" (" + sum + ") -> ");
                int processedDec = processDecimalNumber(sum);
                finalDiff += Math.abs(line.length() - processedDec);
            }
        }
        

        System.out.println("Final Result: " + finalDiff);

    }
}
