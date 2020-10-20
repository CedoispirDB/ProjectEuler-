import java.util.HashMap;
import java.util.Map;

public class numberLetterCounts17 {
    public static void main(String[] args) {
        Map<Integer, String> n = new HashMap<>();
        int lettersSum = 0;
        n.put(0, "");
        n.put(1, "one");
        n.put(2, "two");
        n.put(3, "three");
        n.put(4, "four");
        n.put(5, "five");
        n.put(6, "six");
        n.put(7, "seven");
        n.put(8, "eight");
        n.put(9, "nine");
        n.put(10, "ten");
        n.put(11, "eleven");
        n.put(12, "twelve");
        n.put(13, "thirteen");
        n.put(14, "fourteen");
        n.put(15, "fifteen");
        n.put(16, "sixteen");
        n.put(17, "seventeen");
        n.put(18, "eighteen");
        n.put(19, "nineteen");
        n.put(20, "twenty");
        n.put(30, "thirty");
        n.put(40, "forty");
        n.put(50, "fifty");
        n.put(60, "sixty");
        n.put(70, "seventy");
        n.put(80, "eighty");
        n.put(90, "ninety");

        for (int i = 1; i <= 1000; i++) {
            String text = "";
            int j = i;

            // Thousands
            if (j >= 1000) {
                text = getThousandsName(n, i);
                j = Integer.parseInt(String.valueOf(j).substring(1));
            }

            // Hundreds
            if (j < 1000 && j >= 100) {
                text = text + getHundredsName(n, j);
                j = Integer.parseInt(String.valueOf(j).substring(1));
            }

            if (j > 0 && !text.isEmpty()) {
                text = text + "and ";
            }

            // Tens
            if (j < 100 && j >= 20) {
                text = text + getTensName(n, j);
                j = Integer.parseInt(String.valueOf(j).substring(1));
            }

            // Tens
            if (j < 20) {
                text = text + n.get(j);
            }

            tools.d(i + " = " + text + " (" + text.replace(" ", "").length() + ")");
            lettersSum += text.replace(" ", "").length();
            tools.d(lettersSum);
        }


    }

    private static String getThousandsName(Map<Integer, String> n, int x) {
        String r = "";
        if (x >= 1000) {
            r = n.get((int) Math.ceil(x / 1000)) + " thousand ";
        }

        return r;
    }

    private static String getHundredsName(Map<Integer, String> n, int x) {
        String r = "";
        if (x >= 100) {
            r = n.get((int) Math.ceil(x / 100)) + " hundred ";
        }

        return r;
    }

    private static String getTensName(Map<Integer, String> n, int x) {
        String r = "";
        if (x >= 20) {
            r = n.get(Integer.parseInt(String.valueOf(String.valueOf(x).charAt(0))) * 10) + " ";
        }

        return r;
    }
}
