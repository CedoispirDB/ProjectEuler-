package euler;

import utils.MaT;
import utils.Tools;
public class a47distinctPrimesFactors {


    private static void consecutiveNumbers() {
        int n = 0;
        int consecutive = 0;
        int numberOfFactors = 4;
        int firstN = 0;
        int secondN = 0;
        int thirdN = 0;
        int fourthN = 0;

        do {
            do {
                n++;
                if (!Tools.isItPrime(n)) {
                    if (MaT.primeFactors(n) >= numberOfFactors) {
                        consecutive++;
                        if (firstN == 0) {
                            firstN = n;
                        } else if (secondN == 0) {
                            secondN = n;
                        } else if (thirdN == 0) {
                            thirdN = n;
                        } else if (fourthN == 0) {
                            fourthN = n;
                        }
                    } else {
                        consecutive = 0;
                        firstN = 0;
                        secondN = 0;
                        thirdN = 0;
                        fourthN = 0;
                    }
                }


            } while (consecutive < numberOfFactors);

            if (firstN == secondN - 1 && secondN == thirdN - 1 && thirdN == fourthN - 1){
                Tools.d(firstN);
                Tools.d(secondN);
                Tools.d(thirdN);
                Tools.d(fourthN);
                break;
            }


        } while (true);
    }

    public static void main(String[] args) {
        consecutiveNumbers();
    }
}



