package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[0,0,0], [0,1,0], [0,0,0]]
 * 
 * Output: [[0,0,0], [0,1,0], [0,0,0]]
 * 
 * Example 2:
 * 
 * Input: [[0,0,0], [0,1,0], [1,1,1]]
 * 
 * Output: [[0,0,0], [0,1,0], [1,2,1]]
 * 
 * 
 * Note:
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * 
 * There are at least one 0 in the given matrix.
 * 
 * The cells are adjacent in only four directions: up, down, left and right.
 */
class _542_01Matrix {
    private int[] POINT = { 0, -1, 0, 1, 0 };

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * cols + j);
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int row = cur / cols;
            int col = cur % cols;
            for (int i = 0; i < 4; i++) {
                int newRow = row + POINT[i];
                int newCol = col + POINT[i + 1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }
                if (matrix[newRow][newCol] <= matrix[row][col] + 1) {
                    continue;
                }
                matrix[newRow][newCol] = matrix[row][col] + 1;
                queue.offer(newRow * cols + newCol);
            }
        }
        return matrix;
    }
}