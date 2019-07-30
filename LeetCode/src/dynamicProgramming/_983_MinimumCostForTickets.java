package dynamicProgramming;

/**
 * In a country popular for train travel, you have planned some train travelling
 * one year in advance. The days of the year that you will travel is given as an
 * array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 *
 * a 7-day pass is sold for costs[1] dollars;
 *
 * a 30-day pass is sold for costs[2] dollars.
 *
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days:
 * day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the
 * given list of days.
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15] Output: 11
 *
 */

class _983_MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }
        int len = days.length;
        int[] dp = new int[len];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + costs[0];

            int j = i;
            while (j >= 0 && days[i] - days[j] < 7) {
                j--;
            }
            dp[i] = Math.min(dp[i], costs[1] + (j >= 0 ? dp[j] : 0));

            j = i;
            while (j >= 0 && days[i] - days[j] < 30) {
                j--;
            }
            dp[i] = Math.min(dp[i], costs[2] + (j >= 0 ? dp[j] : 0));
        }
        return dp[len - 1];
    }
}