package unionFind;

import java.util.*;

/**
 * 
 * On a 2D plane, we place stones at some integer coordinate points. Each
 * coordinate point may have at most one stone.
 * 
 * Now, a move consists of removing a stone that shares a column or row with
 * another stone on the grid.
 * 
 * What is the largest possible number of moves we can make?
 * 
 * 
 * Example 1:
 * 
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]] Output: 5
 * 
 * Example 2:
 * 
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]] Output: 3
 * 
 * Example 3:
 * 
 * Input: stones = [[0,0]] Output: 0
 * 
 * Note:
 * 
 * 1 <= stones.length <= 1000 0 <= stones[i][j] < 10000
 */
class Solution {
    private int groups = 0;

    public int removeStones(int[][] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] stone : stones) {
            // use 10000 + stone[1] to avoid union two same elements
            union(map, stone[0], 10000 + stone[1]);
        }
        return stones.length - groups;
    }

    private int find(Map<Integer, Integer> map, int i) {
        if (!map.containsKey(i)) {
            map.put(i, i);
            groups++;
            return i;
        }
        if (i != map.get(i)) {
            map.put(i, find(map, map.get(i)));
        }
        return map.get(i);
    }

    private void union(Map<Integer, Integer> map, int i, int j) {
        int parentI = find(map, i);
        int parentJ = find(map, j);
        if (parentI != parentJ) {
            map.put(parentI, parentJ);
            groups--;
        }
    }
}