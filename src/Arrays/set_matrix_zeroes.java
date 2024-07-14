package Arrays;

import java.util.Arrays;

public class set_matrix_zeroes {
    public static void main(String[] args) {

        // int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 2, 1 } };
        // int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int[][] matrix = { { 0 } };

        optimized_setZeroes(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * @param matrix
     * @timeComplexity => ~O(n*m*(n+m))
     * @spaceComplexity => O(n*m)
     */
    public static void brute_setZeroes(int[][] matrix) {
        int n = matrix.length; // O(1)
        int m = matrix[0].length; // O(1)

        int[][] ans = new int[n][m];

        // O(n*m*(n+m))
        for (int row = 0; row < n; row++) {
            for (int ele = 0; ele < m; ele++) {
                if (matrix[row][ele] == 0) {
                    // set row to zero
                    for (int i = 0; i < m; i++) {
                        ans[row][i] = -1;
                    }

                    // set column to zero
                    for (int i = 0; i < n; i++) {
                        ans[i][ele] = -1;
                    }
                }
            }
        }

        // O(n*m)
        for (int row = 0; row < n; row++) {
            for (int ele = 0; ele < m; ele++) {
                if (ans[row][ele] == -1) {
                    matrix[row][ele] = 0;
                }
            }
        }

    }

    /**
     * @approach => instead of using another array(2d array) to store the new values
     *           we can use 2 array(1d array) to mark an row, column to set it zero.
     * @timeComplexity => O(n*m) + O(n*m) ==> O(2*n*m)
     * @spaceComplexity => O(n + m)
     * @param matrix
     */
    public static void better_setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] markedRows = new int[n];
        int[] markedCols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markedRows[i] = -1;
                    markedCols[j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (markedCols[j] == -1 || markedRows[i] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * @approach => we remove extra space by using first row and first column as
     *           marking arrays, and use int variable for first element(0,0)
     * @timeComplexity => O(n*m) + O(n-1 * m-1) + O(n) + O(m)
     * @spaceComplexity => O(1)
     */
    public static void optimized_setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
