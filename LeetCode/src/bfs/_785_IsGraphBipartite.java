package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split it's set of nodes into two
 * independent subsets A and B such that every edge in the graph has one node in
 * A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for
 * which the edge between nodes i and j exists. Each node is an integer between
 * 0 and graph.length - 1. There are no self edges or parallel edges: graph[i]
 * does not contain i, and it doesn't contain any element twice.
 * 
 */
class _785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null) {
            return false;
        }
        int rows = graph.length;
        int[] colors = new int[rows];
        for (int i = 0; i < rows; i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : graph[cur]) {
                        if (colors[next] == 0) {
                            colors[next] = -1 * colors[cur];
                            queue.offer(next);
                        } else if (colors[next] == colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}