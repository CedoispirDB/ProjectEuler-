package euler;

import java.io.IOException;
import java.nio.file.*;
import utils.Loc;

public class a81PathSum {

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
            System.err.println("Erro: " + e.getMessage());
        }

        return matrix;
    }

    private static int transverse(int[][] matrix, int r, int c, int sum) {
        System.out.println("r: " + r + " c: " + c + " -> " + sum);

        if (r >= matrix.length - 1 && c >= matrix[r].length - 1) {
            return sum;
        }

        if (r >= matrix.length - 1) {
            return transverse(matrix, r, c + 1, sum + matrix[r][c + 1]);
        }

        if (c >= matrix[r].length - 1) {
            return transverse(matrix, r + 1, c, sum + matrix[r + 1][c]);
        }

        if (matrix[r + 1][c] < matrix[r][c + 1]) {
            return transverse(matrix, r + 1, c, sum + matrix[r + 1][c]);
        } else {
            return transverse(matrix, r, c + 1, sum + matrix[r][c + 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        Path matrix_file = Loc.getDesktopFile("matrix2.txt");

        int d = 80;

        int[][] matrix = create_matrix_from_file(matrix_file, d, d);

        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        int last_row_index = matrix.length - 1;
        int last_col_index = matrix[last_row_index].length - 1;

        System.out.println("min_sum: " + transverse(
                matrix,
                0,
                0,
                matrix[0][0]));

    }
}
