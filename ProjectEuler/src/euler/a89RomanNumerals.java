package euler;

import utils.tools;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a89RomanNumerals {

    private static HashMap<String, Integer> rn = new HashMap<>();
    private static int[] decimalsOrder = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500};

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
    }

    // Create roman number and return num of characters
    public static int processDecimalNumber(int decimal) {
        for(int d = 0; d < decimalsOrder.length; d++) {
            if(decimalsOrder[d] > )
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        populateMap();

        Path path = Path.of(System.getProperty("user.home"), "Desktop", "roman2.txt");

        try (var lines = Files.lines(path)) {
            for (String line : lines.toList()) {
                System.out.println("Line: " + line);

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

                    System.out.println("decimal: " + decimal + " decimalNext: " + decimalNext);

                    sum += decimal;

                    i++;
                }

                int processedSum = processDecimalNumber(sum);
                System.out.println("sum: " + sum);
            }
        }

    }
}
