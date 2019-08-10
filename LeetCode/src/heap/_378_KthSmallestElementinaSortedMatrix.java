package heap;

import java.util.*;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * Solution: take the matrix as k sorted lists
 */
class Coordinate {
    int row;
    int col;

    Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class _378_KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int res = 0;
        int count = 0;
        Queue<Coordinate> pq = new PriorityQueue<>((c1, c2) -> matrix[c1.row][c1.col] - matrix[c2.row][c2.col]);
        for (int i = 0; i < matrix.length && i < k; i++) {
            pq.add(new Coordinate(i, 0));
        }
        while (!pq.isEmpty()) {
            Coordinate coor = pq.poll();
            if (++count == k) {
                return matrix[coor.row][coor.col];
            }
            coor.col++;
            if (coor.col < matrix[0].length) {
                pq.offer(coor);
            }
        }
        return res;
    }
}