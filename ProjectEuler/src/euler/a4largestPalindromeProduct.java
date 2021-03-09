package euler;

import java.util.*;
import utils.tools;

public class a4largestPalindromeProduct {
    public static void listOfNumbers(int n,int k) {
        Set<Integer> v = new LinkedHashSet<>();
        int l = 0;


        for (int i = n ; i <= k; i++) {
            //utils.tools.l(i);
            v.add(i);


        }
        //v.forEach(System.out::println);

        for (int x : v) {
            for (int m = n; m <= k; m++) {
                int h = x * m;

                String str = String.valueOf(h);

                if (str.length() % 2 == 0) {
                    int w = str.length();
                    String p = str.substring(w/2, w);
                    String q = str.substring(0, w/2);
                    StringBuilder reverse = new StringBuilder();
                    for (int i = p.length() - 1; i >= 0; i--) {
                        reverse.append(p.charAt(i));
                    }
                    if (q.equals(reverse.toString())) {

                        if (l < h) {
                            //utils.tools.d(l);
                            l = h;
                        }
                    }
                }
            }

        }
        tools.d(l);


    }

    public static void main(String[] args) {
        listOfNumbers(100,999);
    }
}
