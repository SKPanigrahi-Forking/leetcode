package unionFind;

import java.util.Arrays;

/**
 * 
 * Problem: Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to find the number of
 * connected components in an undirected graph.
 * 
Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note: You can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 *
 */
public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i = 0; i < edges.length; i++){
            union(parent, edges[i][0], edges[i][1]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if (parent[i] == -1) {
                res++;
            }
        }
        return res;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
    
    private void union(int[] parent, int i, int j) {
        int parentI = find(parent, i);
        int parentJ = find(parent, j);
        if (parentI != parentJ) {
            parent[parentI] = parentJ;
        }
    }
}