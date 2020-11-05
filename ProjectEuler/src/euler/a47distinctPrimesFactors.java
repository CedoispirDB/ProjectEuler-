//package euler;
//
//import utils.tools;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class a47distinctPrimesFactors {
//    private static int consecutiveIntegers() {
//        List<Integer> primes = new LinkedList<>();
//        for (int i = 1; i <= 50; i++) {
//            if (tools.isItPrime(i)) {
//                primes.add(i);
//            }
//        }
//
////        primes.forEach(System.out :: println);
//        int past = 0;
//        int product = 0;
//        int count = 0;
//        for (int a1 : primes) {
//            for (int a2 : primes) {
//                    product = a1 * a2 ;
//                    tools.d(a1 + " x " + a2 + " = " + product);
//                    if (product == past + 1) {
//                        past = product;
//                        count++;
//                        if (count == 4) {
//                            tools.d(count);
//                            return product - 3;
//                        }
//
//
//
//                }
//
//            }
//
//        }
//
//        return product - 3;
//    }
//
//    public static void main(String[] args) {
//        tools.d(consecutiveIntegers());
//    }
//}
//
