import java.util.LinkedHashSet;
import java.util.Set;

public class distinctPowers29 {
    public static int distinctPowers(int limit) {
        Set<Double> results = new LinkedHashSet<>();
        double result;
        for (int b = 2; b <= limit; b++) {
            for (int a = 2; a <= limit; a++) {
                result = Math.pow(a, b);
                results.add(result);
            }
        }

        return results.size();
    }

    public static void main(String[] args) {
        tools.d(distinctPowers(100));
    }
}
