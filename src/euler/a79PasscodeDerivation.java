package euler;

import java.util.*;
import utils.*;

public class a79PasscodeDerivation {

    private static void swap(LinkedList<Integer> list, int i, int j) {
        int r = list.remove(i);
        list.add(j, r);
    }

    private static void handletrio(LinkedList<Integer> list, int a, int b, int c) {
        int index_a = list.indexOf(a);
        int index_b = list.indexOf(b);
        int index_c = list.indexOf(c);

        if(index_a >= 0 && index_b >= 0 && index_c >= 0) {
            if(index_a > index_b) {
                swap(list, index_a, index_b);
            }

            if(index_a > index_c) {
                swap(list, index_a, index_c);
            }

            if(index_b > index_c) {
                swap(list, index_b, index_c);
            }

            return;
        }
        
        if(index_a < 0) {
            list.add(a);
        }
    
        if(index_b < 0) {
            list.add(b);
        }

        if(index_c < 0) {
            list.add(c);
        }


        handletrio(list, a, b, c);
    }

    public static void main(String[] args) {
        List<String> lines = Loc.getFileLines("keylog.txt");

        LinkedList<Integer> pass = new LinkedList<>();

        for (String line : lines) {
            Log.println("Parsing: " + line);
            int a = Tools.charToDigit(line.charAt(0));
            int b = Tools.charToDigit(line.charAt(1));
            int c = Tools.charToDigit(line.charAt(2));

            handletrio(pass, a, b, c);
        }

        Log.listToStr(pass);

    }
}
