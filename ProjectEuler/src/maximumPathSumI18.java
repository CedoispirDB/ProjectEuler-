import java.util.*;

public class maximumPathSumI18 {

    public static int getRow(int position) {
        int sum = 0;
        int r = 0;
        for (int row = 1; row <= 15; row++) {
            sum += row;
            if (position <= sum) {
                r = row - 1;
                break;
            }
        }
        return r;
    }

    public static int adjacentSum() {

        List<Integer> triangle = Arrays.asList(75, 95, 64, 17, 47, 82, 18, 35, 87, 10, 20, 4, 82, 47, 65, 19, 1, 23, 75, 3, 34, 88, 2, 77, 73, 7, 63, 67, 99, 65, 4, 28, 6, 16, 70, 92, 41, 41, 26, 56, 83, 40, 80, 70, 33, 41, 48, 72, 33, 47, 32, 37, 16, 94, 29, 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14, 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57, 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31, 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23);
        int sum = 0;
        int sum2 = 0;
        int check = 0;
        int next = 0;
        int next2 = 0;
        int position;
        int position2;
        for (int i = 1; i < triangle.size(); i++) {

            tools.d("Sum: " + sum);
        }
        return check;
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 120; i++) {
            tools.d("Row of position " + i + " is " + getRow(i) + "\n");
        }
        tools.d(adjacentSum());
    }
}


//                       75,
//                       95, 64,
//                       17, 47, 82,
//                       18, 35, 87, 10,
//                       20, 4, 82, 47, 65,
//                       19, 1, 23, 75, 3, 34,
//                       88, 2, 77, 73, 7, 63, 67,
//                       99, 65, 4, 28, 6, 16, 70, 92,
//                       41, 41, 26, 56, 83, 40, 80, 70, 33,
//                       41, 48, 72, 33, 47, 32, 37, 16, 94, 29,
//                       53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14,
//                       70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
//                       91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,
//                       63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31,
//                       4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23