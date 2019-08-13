package unionFind;

import java.util.Arrays;

/**
 * 
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge
 * is a pair of nodes), write a function to check whether these edges make up a
 * valid tree.
 * 
 * Example 1:
 * 
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]] Output: true
 * 
 * Example 2:
 * 
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]] Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0,1] is the same as [1,0] and thus will not appear
 * together in edges.
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < edges.length; i++) {
            int parentI = find(parent, edges[i][0]);
            int parentJ = find(parent, edges[i][1]);
            // circle in the graph
            if (parentI == parentJ) {
                return false;
            }
            // union
            parent[parentI] = parentJ;
        }
        return edges.length == n - 1;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}