import java.util.*;

public class maximumPathSumI18 {

    public static int maxSum = 0;
    public static List<String> allPaths = new LinkedList<>();

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

    private static int getNextPosition(int currentPosition, List<Integer> numbers, String hasBeen) {
        int sum = 0;
        for (int inc = 1; inc <= 2; inc++) {
            int nextPos = currentPosition + getRow(currentPosition) + inc;

            // If not duplicate, add to string
            if (!hasBeen.contains(String.valueOf(currentPosition))) {
                hasBeen = hasBeen + currentPosition + ",";
            }

            // If last item on list
            if (nextPos >= (numbers.size() + 1)) {
                sum = numbers.get(currentPosition - 1);
                // Adds to list if list not already filled
                if (!hasBeen.contains("|")) {
                    allPaths.add(hasBeen.substring(0, hasBeen.length() - 1));
                }
                hasBeen = hasBeen + "|";
            } else if (nextPos <= numbers.size()) {
                //tools.d("Pass " + (++paths) + " Current Position " + currentPosition + ", Current Number " + numbers.get(currentPosition - 1) + " next Position : " + nextPos + ", next Number : " + numbers.get(nextPos - 1) + ", Row:" + getRow(currentPosition) );
                sum = numbers.get(currentPosition - 1) + getNextPosition(nextPos, numbers, hasBeen);
            }
        }

        return sum;

    }

    public static void main(String[] args) {

        List<Integer> triangle = Arrays.asList(75, 95, 64, 17, 47, 82, 18, 35, 87, 10, 20, 4, 82, 47, 65, 19, 1, 23, 75, 3, 34, 88, 2, 77, 73, 7, 63, 67, 99, 65, 4, 28, 6, 16, 70, 92, 41, 41, 26, 56, 83, 40, 80, 70, 33, 41, 48, 72, 33, 47, 32, 37, 16, 94, 29, 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14, 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57, 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31, 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23);

        // Calls recursive function
        getNextPosition(1, triangle, "");

        // Parse Strings from AllPaths List
        for (String pa : allPaths) {
            int sum = 0;
            for (String p : pa.split(",")) {
                sum = sum + triangle.get(Integer.parseInt(p) - 1);
            }

            tools.d("Path: " + pa + " Sum: " + sum);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }


        tools.d(maxSum);

    }
}