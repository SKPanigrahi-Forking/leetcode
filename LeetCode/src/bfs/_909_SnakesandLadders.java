package bfs;

import java.util.*;

/**
 * 
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically
 * starting from the bottom left of the board, and alternating direction each
 * row.
 */
class _909_SnakesandLadders {
    public int snakesAndLadders(int[][] board) {
        int cols = board[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == cols * cols) {
                return map.get(cur);
            }
            for (int next = cur + 1; next <= Math.min(cur + 6, cols * cols); next++) {
                int nextIdx = getIdx(next, cols);
                int row = nextIdx / cols;
                int col = nextIdx % cols;
                int realNext = board[row][col] == -1 ? next : board[row][col];
                if (!map.containsKey(realNext)) {
                    map.put(realNext, map.get(cur) + 1);
                    queue.add(realNext);
                }
            }
        }
        return -1;
    }

    private int getIdx(int cur, int cols) {
        int a = (cur - 1) % cols;
        int row = cols - 1 - (cur - 1) / cols;
        int col = row % 2 != cols % 2 ? a : cols - 1 - a;
        return row * cols + col;
    }
}