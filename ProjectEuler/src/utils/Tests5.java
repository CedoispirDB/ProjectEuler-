package utils;

import java.util.Arrays;
import java.util.List;

public class Tests5 {

    // x goes 0 -> 3
    // y goes 0 -> 3
    //
    public static void main(String[] args) {
        List<Integer> k = Arrays.asList(3, 7, 4, 2, 4, 6, 8, 5, 9, 3);
        int[][] n = new int[10][20];
        int sum = 0;
        int pos;
        int nextPos;
        int t;
        int row = 1;
        int i = 0;
        int max = 0;

        for (int j = 0; j < 4; j++) {
            for (int x = 1; x <= row; x++) {
                pos = n[x][row] = k.get(i);
//                tools.d("n[" + x + "][" + row + "]" + " = " + k.get(i));
//                tools.d("pos: " + pos);
                i++;
            }
            row++;
        }

        row = 0;

        for (int y = 0; y <= 4; y++) {
            for (int x = 0; x <= 1; x++) {
                pos = n[x][y];
                nextPos = n[x + 1][y];
                if (pos != 0 && nextPos != 0) {
//                    tools.d("x: " + x + " || y: " + y);
//                    tools.d(pos);
                    row++;
                    max = Math.max(pos, nextPos);
                    tools.d("pos: " + pos + ", nexPos: " + nextPos + " max: " + max);
                } else if (x == 1 && y == 1) {
                    max = pos;
                }
            }
            if (max != 0) {
                sum += max;
                tools.d("sum : " + sum);
            }
        }
    }
}


//3
//7 4
//2 4 6
//8 5 9 3

//75
//95 64
//17 47 82
//18 35 87 10
//20 04 82 47 65
//19 01 23 75 03 34
//88 02 77 73 07 63 67
//99 65 04 28 06 16 70 92
//41 41 26 56 83 40 80 70 33
//41 48 72 33 47 32 37 16 94 29
//53 71 44 65 25 43 91 52 97 51 14
//70 11 33 28 77 73 17 78 39 68 17 57
//91 71 52 38 17 14 91 43 58 50 27 29 48
//63 66 04 68 89 53 67 30 73 16 69 87 40 31
//04 62 98 27 23 09 70 98 73 93 38 53 60 04 23