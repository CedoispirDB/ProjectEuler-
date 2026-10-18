package euler;
import utils.Tools;

public class a30digitFifthPowers {
    private static long sumOfPowers(){
        String numStr;
        int sum;
        long totalSum = 0;
        for (int i = 10; i <= 1000000; i++){
            sum = 0;
            Tools.d(  "i: " + i);

            numStr = String.valueOf(i);

            for (int x = 0; x < numStr.length(); x++){
                sum += Tools.exponent(Integer.parseInt(String.valueOf(numStr.charAt(x))),5);
            }
            Tools.d("sum after : " + sum + "\n");
            if (sum == i){
                totalSum += i;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        Tools.d(sumOfPowers());
    }
}
