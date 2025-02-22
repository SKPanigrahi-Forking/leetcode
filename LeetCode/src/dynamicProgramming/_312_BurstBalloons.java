package dynamicProgramming;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *
 * Input: [3,1,5,8]
 *
 * Output: 167
 *
 * Explanation: nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 *
 * coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 */
class _312_BurstBalloons {
    public int maxCoins(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        int[] newNums = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = 1;
        newNums[len + 1] = 1;
        int[][] dp = new int[len + 2][len + 2];
        for (int win_len = 1; win_len <= len; win_len++) {
            for (int i = 1; i <= len && i + win_len - 1 <= len; i++) {
                int j = i + win_len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + dp[k + 1][j] +
                                    newNums[i - 1] * newNums[k] * newNums[j + 1]);
                }
            }
        }
        return dp[1][len];
    }
}