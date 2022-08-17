package euler;

import utils.tools;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Not done

public class a79PasscodeDerivation {
    // since is the shortest the number can not have a repeated number
    // 0123456789
    // 319000000
    // 031900000
    // 3190245678
    // Suppose that the shortest has 4 digits
    private static void checkCodes(List<String> passCodes) {

//        String code = passCodes.get(0);
//        LinkedList<String> poss = new LinkedList<>();
//
//        for (int i = 0; i < 10; i++) {
//            if (!code.contains(String.valueOf(i))) {
//                poss.add(String.valueOf(i));
//            }
//        }

        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> copy = new LinkedList<>(passCodes);


        for (String code : copy) {
            if (!list.contains(code)) {
                list.add(code);
            }
        }
        System.out.println(list);
    }


    public static void main(String[] args) {
        List<String> codes = Arrays.asList(
                "319", "680", "180", "690", "129",
                "620", "762", "689", "762",
                "318", "368", "710", "720",
                "710", "629", "168", "160",
                "689", "716", "731", "736",
                "729", "316", "729", "729",
                "710", "769", "290", "719",
                "680", "318", "389", "162",
                "289", "162", "718", "729",
                "319", "790", "680", "890",
                "362", "319", "760", "316",
                "729", "380", "319", "728",
                "716");

        checkCodes(codes);


    }
}
