
import java.lang.reflect.Array;
import java.util.*;

public class Tests {
    public static void main(String[] args) {
        List<String> x = Arrays.asList("Marco", "Marcelo", "Agda", "Luana", "Bia", "Bianca");
        Collections.sort(x);
        x.forEach(System.out::println);
        int position = 0;
        for (String name : x) {
            position = x.indexOf(name) + 1;
        }
        tools.d(position);
    }

}