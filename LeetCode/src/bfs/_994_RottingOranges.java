package bfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] POINTS = { 0, -1, 0, 1, 0 };
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * cols + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int row = cur / cols;
                int col = cur % cols;
                for (int j = 0; j < 4; j++) {
                    int newRow = row + POINTS[j];
                    int newCol = col + POINTS[j + 1];
                    int newIdx = newRow * cols + newCol;
                    if (newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols 
                       && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(newIdx);
                    }
                }
            }
            res++;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res == 0 ? 0 : res - 1;
    }
}