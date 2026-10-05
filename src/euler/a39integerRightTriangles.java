package euler;

import utils.tools;

import java.util.LinkedList;
import java.util.List;

public class a39integerRightTriangles {

    //Check if the lengths forms a right triangle
    private static boolean findRightTriangle(int a, int b, int c) {
        boolean isRight = false;
        double h;
        double h2;
        double h3;
        h = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        h2 = Math.sqrt(Math.pow(c, 2) + Math.pow(b, 2));
        h3 = Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2));
        if (h == c || h2 == a || h3 == b) {
            if (Math.floor(h) == h || Math.floor(h2) == h2 || Math.floor(h3) == h3) {
                isRight = true;
            }
        }
        return isRight;
    }

    //Count the number of solutions to a certain perimeter p in a right triangle
    private static int numOfSolutions(int p) {
        List<Integer> pastNum = new LinkedList<>();
        int sum;
        int count = 0;
        for (int i = 1; i < p; i++) {
            for (int j = 1; j < p; j++) {
                for (int k = 1; k < p; k++) {
                    sum = i + j + k;
                    if (sum == p && findRightTriangle(i, j, k) && !pastNum.contains(i) && !pastNum.contains(j) && !pastNum.contains(k)) {
                        pastNum.add(i);
                        pastNum.add(j);
                        pastNum.add(k);
                        count++;
                    }
                }

            }
        }
        return count;
    }

    //Find all sums in the range p <= 1000
    private static long totalNP() {
        int solutions;
        int amount = 0;
        int result = 0;
        for (int p = 1; p <= 1000; p++) {
            solutions = numOfSolutions(p);
            if (solutions > amount) {
                amount = solutions;
                result = p;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        tools.d(totalNP());
    }
}
