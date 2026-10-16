package euler;

import java.io.IOException;
import java.nio.file.*;
import utils.Loc;

public class a81PathSum {

    private static int min_sum = Integer.MAX_VALUE;
    private static int path_count = 0;
    private static int[][] dp;

    private static int[][] create_matrix_from_file(Path matrix_file, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int i = 0;
        int j = 0;

        try (var lines = Files.lines(matrix_file)) {
            for (String line : lines.toList()) {
                String[] row = line.split(",");
                for (String col : row) {
                    matrix[i][j] = Integer.valueOf(col);

                    j++;
                    if (j >= cols) {
                        break;
                    }
                }

                j = 0;

                i++;
                if (i >= rows) {
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return matrix;
    }

    private static void transverse(int[][] matrix) {
        int row_count = matrix.length;

        for (int r = 0; r < row_count; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int r_i = r - 1;
                if (r_i < 0) {
                    r_i = 0;
                }

                int c_i = c - r;
                if (c_i < 0) {
                    c_i = 0;
                }

                dp[r][c] = matrix[r][c] + Math.min(dp[r_i][c], dp[r][c_i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path matrix_file = Loc.getDataPath("matrix2.txt");

        int rows = 5;
        int cols = 5;

        dp = new int[rows][cols];

        int[][] matrix = create_matrix_from_file(matrix_file, rows, cols);

        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        int last_row_index = matrix.length - 1;
        int last_col_index = matrix[last_row_index].length - 1;

        transverse(matrix);
        System.out.println("min_sum: " + min_sum);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
