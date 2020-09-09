public class latticePaths15 {

    static int counter = 0;

    private static void getNextMove(int gridRows, int gridColumns, String v) {

        int r = Integer.parseInt(v.split(",")[0]);
        int c = Integer.parseInt(v.split(",")[1]);

        tools.d(r + "," + c + " : Vertex");

        // Moves Column
        if (c < gridColumns) {
            if (r == gridRows && (c + 1) == gridColumns) {
                tools.d(gridRows + "," + gridColumns + " : Path Completed (via " + v + ")!");
                counter++;
            } else {
                getNextMove(gridRows, gridColumns, (r + "," + (c + 1)));
            }
        }

        // Moves Row
        if (r < gridRows) {
            if ((r + 1) == gridRows && c == gridColumns) {
                tools.d(gridRows + "," + gridColumns + " : Path Completed (via " + v + ")!");
                counter++;
            } else {
                getNextMove(gridRows, gridColumns, ((r + 1) + "," + c));
            }
        }
    }

    public static void main(String[] args) {
        getNextMove(3, 3, "0,0");
        tools.d("Total "+ counter);

    }
}
