/**
 * Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After
 * partitioning, each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning.
 *
 *
 * Example 1:
 *
 * Input: A = [1,15,7,9,2,5,10], K = 3
 *
 * Output: 84
 *
 * Explanation: A becomes [15,15,15,9,10,10,10]
 */

class _1043_PartitionArrayforMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        int curMax = 0;
        for (int i = 0; i < len; i++) {
            curMax = 0;
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                curMax = Math.max(curMax, A[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + curMax * j);
            }
        }
        return dp[len - 1];
    }
}