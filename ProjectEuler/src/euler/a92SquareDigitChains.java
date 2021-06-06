package euler;

import utils.tools;

public class a92SquareDigitChains {

    public static boolean createChain(String initialValue) {
        int sum = 0;

        if (initialValue.equals("89")) {
            return true;
        } else if (initialValue.equals("1")) {
            return false;
        }

        for (int i = 0; i < initialValue.length(); i++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(initialValue.charAt(i))), 2);

        }

        return createChain(String.valueOf(sum));
    }


    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 10000000 ; i++) {
            if (createChain(String.valueOf(i))) {
                count ++;
            }
        }

        tools.d("answer: " + count);
    }
}
