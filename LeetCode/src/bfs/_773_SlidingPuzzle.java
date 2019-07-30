package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5,
 * and an empty square represented by 0.
 * 
 * A move consists of choosing 0 and a 4-directionally adjacent number and
 * swapping it.
 * 
 * The state of the board is solved if and only if the board is
 * [[1,2,3],[4,5,0]].
 * 
 * Given a puzzle board, return the least number of moves required so that the
 * state of the board is solved. If it is impossible for the state of the board
 * to be solved, return -1.
 * 
 * Examples:
 * 
 * Input: board = [[1,2,3],[4,0,5]] Output: 1 Explanation: Swap the 0 and the 5
 * in one move. Input: board = [[1,2,3],[5,4,0]] Output: -1 Explanation: No
 * number of moves will make the board solved.
 */
class _773_SlidingPuzzle {
    private int[] POINTS = { 0, -1, 0, 1, 0 };

    private String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }

    public int slidingPuzzle(int[][] board) {
        String targ = "123450";
        String start = "";
        int rows = board.length;
        int cols = board[0].length;
        int res = 0;
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                start += board[i][j];
            }
        }
        queue.offer(start);
        set.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(targ)) {
                    return res;
                }
                int zeroPos = cur.indexOf('0');
                int row = zeroPos / cols;
                int col = zeroPos % cols;
                for (int k = 0; k < 4; k++) {
                    int newRow = row + POINTS[k];
                    int newCol = col + POINTS[k + 1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        String next = swap(cur, zeroPos, newRow * cols + newCol);
                        if (set.contains(next)) {
                            continue;
                        }
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
