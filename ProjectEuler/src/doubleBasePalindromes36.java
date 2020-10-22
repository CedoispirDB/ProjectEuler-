public class doubleBasePalindromes36 {

    private static String rotateNum(String sequence, String x) {
        String newString = String.valueOf(sequence.charAt(sequence.length() - 1));
        String rest = sequence.substring(0,sequence.length() - 1);
        x = x + newString;
        if (rest.equals("")) {
            return x;

        }

        return rotateNum(rest, x);
    }

    private static String intToByte(int i) {
        return Integer.toBinaryString(i);
    }

    private static boolean checkForP(String number) {
        int nLength = number.length();
        String fPart;
        String sPart;
        boolean isItP = false;
        if (nLength == 1){
            return true;
        }
        if (nLength % 2 == 0) {
            fPart = number.substring(0, nLength / 2);
            sPart = number.substring(nLength / 2, nLength);
            if (fPart.equals(rotateNum(sPart,""))){
                isItP = true;
            }
        } else {
            fPart = number.substring(0, nLength / 2);
            sPart = number.substring(nLength / 2 + 1, nLength);
            if (fPart.equals(rotateNum(sPart,""))){
                isItP = true;
            }
        }
        return isItP;
    }

    private static int sumOfPN(int limit) {
        int sum = 0;
        String iStr;
        for (int i = 1; i <= limit; i++) {
            iStr = String.valueOf(i);
            if (checkForP(iStr)){
                if (checkForP(intToByte(i))){
                    tools.d("The sum is: " + sum + " | " + "i: " + i + ", iB: " + intToByte(i));
                    sum += i;

                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
            tools.d(sumOfPN(1000000));
    }
}
