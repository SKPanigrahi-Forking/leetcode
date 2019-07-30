package bfs;

import java.util.*;

/**
 * 
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * 
 * A clear path from top-left to bottom-right has length k if and only if it is
 * composed of cells C_1, C_2, ..., C_k such that:
 * 
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are
 * different and share an edge or corner) C_1 is at location (0, 0) (ie. has
 * value grid[0][0]) C_k is at location (N-1, N-1) (ie. has value
 * grid[N-1][N-1]) If C_i is located at (r, c), then grid[r][c] is empty (ie.
 * grid[r][c] == 0). Return the length of the shortest such clear path from
 * top-left to bottom-right. If such a path does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[0,1],[1,0]] Output: 2
 * 
 * Example 2:
 * 
 * Input: [[0,0,0],[1,1,0],[1,1,0]] Output: 4
 * 
 * 
 * Note:
 * 
 * 1 <= grid.length == grid[0].length <= 100 grid[r][c] is 0 or 1
 */

class Solution {
    private int[][] POINTS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int row = cur / cols;
                int col = cur % cols;
                if (row == rows - 1 && col == cols - 1) {
                    return res;
                }
                for (int j = 0; j < POINTS.length; j++) {
                    int newRow = row + POINTS[j][0];
                    int newCol = col + POINTS[j][1];
                    int newIdx = newRow * cols + newCol;
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited.contains(newIdx)
                            && grid[newRow][newCol] == 0) {
                        queue.offer(newIdx);
                        visited.add(newIdx);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}