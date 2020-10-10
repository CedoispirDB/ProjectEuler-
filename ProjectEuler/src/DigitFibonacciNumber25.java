import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.List;

public class DigitFibonacciNumber25 {

    private static void sumOfStrings(String a, String b) {
        List<Integer> listA = new LinkedList<>();
        List<Integer> listB = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        int firstNumber;
        int secondNumber;
        int comparison = 0;
        int sum;
        int tenth;
        int unit;
        int rest = 0;

        if (a.length() > b.length()) {
            comparison = a.length() - b.length();
        } else if (a.length() < b.length()) {
            comparison = b.length() - a.length();
        }

        if (a.length() > b.length()) {
            do {
                listB.add(0);
            } while (listB.size() != comparison);

        } else if (a.length() < b.length()) {
            do {
                listA.add(0);
            } while (listA.size() != comparison);

        }

        for (int i = 0; i < a.length(); i++) {
            listA.add(Integer.parseInt(String.valueOf(a.charAt(i))));//
        }
        for (int i = 0; i < b.length(); i++) {
            listB.add(Integer.parseInt(String.valueOf(b.charAt(i))));
        }

        for (int i = listA.size() - 1; i >= 0; i--) {
            firstNumber = listA.get(i);
            secondNumber = listB.get(i);
            sum = firstNumber + secondNumber + rest;
            /*
            if (firstNumber >= secondNumber && sum >= 10) {

                tenth = String.valueOf(sum).charAt(0);
                unit = String.valueOf(sum).charAt(1);
                result.add(tenth);
                result.add(unit);
            } else {
                result.add(sum);
            }
        */
            result.add(sum);
            if (result.indexOf(0) == 0){
                result.remove(0);
                result.add(0);

            }

        }


        listA.forEach(System.out::print);
        tools.l(" ");
        listB.forEach(System.out::print);
        tools.l(" ");
        result.forEach(System.out::print);


    }

    public static long fibonacciSequence() {
        long a1 = 1;
        long a2 = 0;
        long sum;
        boolean found = true;
        do {
            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
            String strSum = String.valueOf(sum);


            if (strSum.length() == 1000) {
                tools.d("a");
                found = false;
            }
        } while (found);

        return sum;
    }

    public static void main(String[] args) {
        sumOfStrings("90", "91");
    }
}
