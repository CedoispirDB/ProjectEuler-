package utils;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class Tests {



    public static boolean checkIfPandigital(String number, int s) {
        boolean isPan = false;
        if (number.length() != 10){
            return false;
        }
        for (int i = s; i <= 9; i++) {
            if (number.contains(String.valueOf(i))){
                isPan = true;
            } else {
                isPan = false;
                break;
            }
        }
        return isPan;
    }

    public static void main(String[] args) {
        tools.d(checkIfPandigital("1406357289", 0));
    }
}
