package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 *
 */
public class _053_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int[] db = new int[len];
		db[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < len; i++) {
			db[i] = nums[i] + (db[i - 1] > 0 ? db[i - 1] : 0);
			max = Math.max(max, db[i]);
		}
		return max;
	}

	public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}
