package euler;

import utils.tools;

public class a40ChampernownesConstant {

    private static StringBuilder decimals() {
        StringBuilder decimals = new StringBuilder();
        for (int i = 0; i <= 1000000; i++) {
            decimals.append(i);
        }
        return decimals;
    }

    private static int multiplications(StringBuilder d){
        int product = 1;
        for (int i = 1; i <= 1000000; i = i * 10) {
            product *= Integer.parseInt(String.valueOf(d.charAt(i)));
        }
        return product;
    }

    public static void main(String[] args) {
        tools.d(multiplications(decimals()));
    }
}
