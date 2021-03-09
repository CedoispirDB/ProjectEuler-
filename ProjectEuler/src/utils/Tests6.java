package utils;

import java.util.Arrays;
import java.util.List;

public class Tests6 {

    public static void triangle() {
        // y
        int maxRow = 4;
        // x
        int maxCol = 3;

        int pos;
        int nextPos;
        int row = 2;
        int col = 0;
        int maxNum = 0;

//        List<Integer> t = Arrays.asList(3, 7, 4, 2, 4, 6, 8, 5, 9, 3);
        List<Integer> t = Arrays.asList(3, 9, 5, 8, 6, 4, 2, 4, 7, 3);


//        pos = t.get(t.size() - maxCol + i);
//        nextPos = t.get(t.size() - maxCol + i + 1);
//        tools.d(pos);
//        tools.d((nextPos));
//        maxNum = Math.max(pos, nextPos);
//
//        tools.d(maxNum);

        for (int i = 0; i < maxCol; i++) {
            pos = t.get(i);
            nextPos = t.get(i + 1);
            tools.d("pos: " + pos);
            tools.d("nexPos: " + nextPos);
            maxNum = Math.max(pos, nextPos);
            tools.d("maxNum: " + maxNum);

        }



    }

    public static void main(String[] args) {
        triangle();
    }

}

//3
//7 4
//2 4 6
//8 5 9 3