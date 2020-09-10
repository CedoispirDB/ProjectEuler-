public class latticePaths15 {

    static long totalFound = 0;

    private static long getNextMove(int gridRows, int gridColumns, int r, int c) {

        long counter = 0;

        // Moves Column
        if (c < gridColumns) {
            if (r == gridRows && (c + 1) == gridColumns) {
                counter++;
                ++totalFound;
                if (totalFound % 20000000 == 0) {
                    tools.d(gridRows + "," + gridColumns + " : Path Completed (" + totalFound + " so far)!");
                }
            } else {
                counter = counter + getNextMove(gridRows, gridColumns, r, (c + 1));
            }
        }

        // Moves Row
        if (r < gridRows) {
            if ((r + 1) == gridRows && c == gridColumns) {
                counter++;
                ++totalFound;
                if (totalFound % 20000000 ==0) {
                    tools.d(gridRows + "," + gridColumns + " : Path Completed ("+ totalFound +" so far)!");
                }
            } else {
                counter = counter + getNextMove(gridRows, gridColumns, (r + 1), c);
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        tools.d("Total " + getNextMove(20, 20, 0, 0));

    }
}
