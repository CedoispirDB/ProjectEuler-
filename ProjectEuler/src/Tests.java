public class Tests {
    public static void main(String[] args) {
        int sumOfDivisors = 0;
        int x = 284;
        for (int i = 1; i < x; i++){
            if (x % i == 0){
                sumOfDivisors += i;
            }
        }
        tools.d(sumOfDivisors);
    }
}