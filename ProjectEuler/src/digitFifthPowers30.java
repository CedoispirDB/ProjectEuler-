public class digitFifthPowers30 {
    private static long sumOfPowers(){
        String numStr;
        int sum;
        long totalSum = 0;
        for (int i = 10; i <= 1000000; i++){
            sum = 0;
            tools.d(  "i: " + i);

            numStr = String.valueOf(i);

            for (int x = 0; x < numStr.length(); x++){
                sum += tools.exponent(Integer.parseInt(String.valueOf(numStr.charAt(x))),5);
            }
            tools.d("sum after : " + sum + "\n");
            if (sum == i){
                totalSum += i;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        tools.d(sumOfPowers());
    }
}
