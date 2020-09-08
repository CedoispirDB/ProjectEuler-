public class longestCollatzSequence14 {
    //Count how many numbers there is in the chain
    public static long quantityOfNumbers(long n) {
        long count = 0;
        do {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            count++;


        } while (n != 1);
        return count + 1;
    }

    //Find the longest chain
    public static long longestChain() {
        long QuantityInChain;
        long previousQuantityInChain = 0;
        long greatestChain = 0;
        long numbers;
        for (numbers = 2; numbers < 1000000; numbers++) {
            QuantityInChain = quantityOfNumbers(numbers);
            //tools.d("For the number " + numbers + " the quantity of numbers in the chain is " + x);

            if (QuantityInChain > previousQuantityInChain) {
                previousQuantityInChain = QuantityInChain;
                //tools.d("n: " + n);
                greatestChain = numbers;
            }

        }
        return greatestChain;

    }

    public static void main(String[] args) {
        tools.d("The number with longest chain is: " + longestChain());
        //tools.d(quantityOfNumbers(2));
        //"The greatest chain is from the number " + greatestChain + " with " + n + " number in the sequence.";
    }

}
