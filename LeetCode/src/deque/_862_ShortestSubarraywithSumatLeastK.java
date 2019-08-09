package deque;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * 
 * Return the length of the shortest, non-empty, contiguous subarray of A with
 * sum at least K.
 * 
 * If there is no non-empty subarray with sum at least K, return -1.
 * 
 * Example 1:
 * 
 * Input: A = [1], K = 1 Output: 1
 * 
 * Example 2:
 * 
 * Input: A = [1,2], K = 4 Output: -1
 * 
 * Example 3:
 * 
 * Input: A = [2,-1,2], K = 3 Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 50000 -10 ^ 5 <= A[i] <= 10 ^ 5 1 <= K <= 10 ^ 9
 */

class Solution {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int res = Integer.MAX_VALUE;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= len; i++) {
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= K) {
                res = Math.min(res, i - deque.pollFirst());
            }
            deque.addLast(i);
        }
        return res <= len ? res : -1;
    }
}