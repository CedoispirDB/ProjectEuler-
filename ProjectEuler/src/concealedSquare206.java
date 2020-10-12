import java.math.BigInteger;

public class concealedSquare206 {

    private static long findPositiveInteger() {
        long number = 1000000000;
        BigInteger numberSquared;
        String numberSquaredStr;
        long result;


        do {
            numberSquared = tools.exponentB(number, 2);
            numberSquaredStr = String.valueOf(numberSquared);
            if (numberSquaredStr.length() == 19 && String.valueOf(numberSquaredStr.charAt(0)).equals("1") && String.valueOf(numberSquaredStr.charAt(2)).equals("2") && String.valueOf(numberSquaredStr.charAt(4)).equals("3") && String.valueOf(numberSquaredStr.charAt(6)).equals("4") && String.valueOf(numberSquaredStr.charAt(8)).equals("5") && String.valueOf(numberSquaredStr.charAt(10)).equals("6") && String.valueOf(numberSquaredStr.charAt(12)).equals("7") && String.valueOf(numberSquaredStr.charAt(14)).equals("8") && String.valueOf(numberSquaredStr.charAt(16)).equals("9") && String.valueOf(numberSquaredStr.charAt(18)).equals("0")) {
                result = number;
                break;
            }
            number++;
        } while (true);

        return result;
    }

    public static void main(String[] args) {
        tools.d(findPositiveInteger());
        //1_2_3_4_5_6_7_8_9_0
        //answer = 1389019170



    }


}
