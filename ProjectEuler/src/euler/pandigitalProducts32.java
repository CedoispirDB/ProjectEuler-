package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class pandigitalProducts32 {
    private static boolean checkIfPandigital(String number) {
        boolean isPan = false;
        for (int i = 1; i <= 9; i++) {
            if (number.contains(String.valueOf(i))){
                isPan = true;
            } else {
                isPan = false;
                break;
            }
        }
        return isPan;
    }

    private static int sumOfProducts() {
        List<Integer> passed = new LinkedList<>();
        int product;
        String productStr;
        int sum = 0;
        for (int a = 1; a < 2000; a++) {
            for (int b = 1; b < 2000; b++) {
                product = a * b;
                productStr = product + String.valueOf(a) + b;
                if (checkIfPandigital(productStr) && !passed.contains(product) && productStr.length() == 9) {
                    passed.add(product);
                    sum += product;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        tools.d(sumOfProducts());
//        tools.d(checkIfPandigital("198765431"));
    }

}
