package dynamicProgramming;

import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 *
 * Example:
 *
 * Input: [ ["1","0","1","0","0"], ["1","0","1","1","1"], ["1","1","1","1","1"],
 * ["1","0","0","1","0"] ]
 *
 * Output: 6
 */

class _085_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] width = new int[cols];

        Arrays.fill(right, cols);
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int curLeft = 0;
            int curRight = cols;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    width[j]++;
                } else {
                    width[j] = 0;
                }
            }
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = cols;
                    curRight = j;
                }
            }
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, (right[j] - left[j]) * width[j]);
            }
        }
        return res;
    }
}