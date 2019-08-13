package unionFind;

import java.util.*;

/**
 * 
 * Problem: A 2d grid map of m rows and n columns is initially filled with
 * water. We may perform an addLand operation which turns the water at position
 * (rows, cols) into a land. Given a list of positions to operate, count the
 * number of islands after each addLand operation. An island is surrounded by
 * water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 *Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water 
and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?:
 *
 */
public class _305_NumberOfIslandsII {
    private int[] POINTS = {0, -1, 0, 1, 0};
    
    public List<Integer> numIslands2(int rows, int cols, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        // store all the parent element
        Set<Integer> set = new HashSet<>();
        int[] parent = new int[rows * cols];
        Arrays.fill(parent, -1);
        for (int[] position : positions) {
            int curRow = position[0];
            int curCol = position[1];
            add(set, parent, curRow, curCol, rows, cols);
            res.add(set.size());
        }
        return res;
    }
    
    private void add(Set<Integer> set, int[] parent, int curRow, int curCol, int rows, int cols) {
        int idx = curRow * cols + curCol;
        parent[idx] = idx;
        set.add(idx);
        for (int i = 0; i < POINTS.length - 1; i++) {
            int newRow = curRow + POINTS[i];
            int newCol = curCol + POINTS[i + 1];
            int newIdx = newRow * cols + newCol;
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && parent[newIdx] != -1) {
                union(set, parent, idx, newIdx);
            }
        }
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
    
    private void union(Set<Integer> set, int[] parent, int i, int j) {
        int parentI = find(parent, i);
        int parentJ = find(parent, j);
        if (parentI != parentJ) {
            parent[parentI] = parentJ;
            set.remove(parentI);
        }
    }
}
