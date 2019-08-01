package bfs;

import java.util.*;

/**
 * 
 * In a given 2D binary array A, there are two islands. (An island is a
 * 4-directionally connected group of 1s not connected to any other 1s.)
 * 
 * Now, we may change 0s to 1s so as to connect the two islands together to form
 * 1 island.
 * 
 * Return the smallest number of 0s that must be flipped. (It is guaranteed that
 * the answer is at least 1.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[0,1],[1,0]] Output: 1
 * 
 * Example 2:
 * 
 * Input: [[0,1,0],[0,0,0],[0,0,1]] Output: 2
 * 
 * Example 3:
 * 
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]] 
 * 
 * Output: 1
 */
class _934_ShortestBridge {
    private int[] POINTS = { 0, -1, 0, 1, 0 };

    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int rows = A.length;
        int cols = A[0].length;
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        outerloop: for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    visited = getVisited(A, visited, i, j);
                    break outerloop;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i : visited) {
            queue.offer(i);
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
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && 
                        !visited.contains(newIdx)) {
                        if (A[newRow][newCol] == 1) {
                            return res;
                        }
                        queue.offer(newIdx);
                        visited.add(newIdx);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private Set<Integer> getVisited(int[][] A, Set<Integer> visited, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        int rows = A.length;
        int cols = A[0].length;
        int curIdx = i * cols + j;
        queue.offer(curIdx);
        visited.add(curIdx);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int row = cur / cols;
            int col = cur % cols;
            for (int k = 0; k < 4; k++) {
                int newRow = row + POINTS[k];
                int newCol = col + POINTS[k + 1];
                int newIdx = newRow * cols + newCol;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && A[newRow][newCol] == 1
                        && !visited.contains(newIdx)) {
                    queue.offer(newIdx);
                    visited.add(newIdx);
                }
            }
        }
        return visited;
    }
}