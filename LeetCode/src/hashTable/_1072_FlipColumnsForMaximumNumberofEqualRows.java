package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a matrix consisting of 0s and 1s, we may choose any number of columns
 * in the matrix and flip every cell in that column. Flipping a cell changes the
 * value of that cell from 0 to 1 or from 1 to 0.
 * 
 * Return the maximum number of rows that have all values equal after some
 * number of flips.
 * 
 * 
 * Example 1:
 * 
 * Input: [[0,1],[1,1]] Output: 1 Explanation: After flipping no values, 1 row
 * has all values equal.
 * 
 * Example 2:
 * 
 * Input: [[0,1],[1,0]] Output: 2
 * 
 * Explanation: After flipping values in the first column, both rows have equal
 * values.
 * 
 * Example 3:
 * 
 * Input: [[0,0,0],[0,0,1],[1,1,0]] Output: 2
 * 
 * Explanation: After flipping values in the first two columns, the last two
 * rows have equal values.
 * 
 * 
 * Note:
 * 
 * 1 <= matrix.length <= 300
 * 
 * 1 <= matrix[i].length <= 300
 * 
 * All matrix[i].length's are equal matrix[i][j] is 0 or 1
 * 
 * Solution: 
 * Find rows that appered most time in the matrix
 * 
 * 1 0 1 '==' 0 1 0
 * 
 */
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            if (row[0] == 1) {
                for (int r : row) {
                    sb.append(1 - r);
                }
            } else {
                for (int r : row) {
                    sb.append(r);
                }
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int v : map.values()) {
            res = Math.max(res, v);
        }
        return res;
    }
}