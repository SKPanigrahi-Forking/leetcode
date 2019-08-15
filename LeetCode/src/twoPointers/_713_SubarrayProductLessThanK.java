package twoPointers;

/**
 * 
 * Your are given an array of positive integers nums.
 * 
 * Count and print the number of (contiguous) subarrays where the product of all
 * the elements in the subarray is less than k.
 * 
 * Example 1: Input: nums = [10, 5, 2, 6], k = 100 Output: 8 Explanation: The 8
 * subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5],
 * [5, 2], [2, 6], [5, 2, 6]. Note that [10, 5, 2] is not included as the
 * product of 100 is not strictly less than k. Note:
 * 
 * 0 < nums.length <= 50000. 0 < nums[i] < 1000. 0 <= k < 10^6.
 */
class Solution {
    // Method1:
    // interate right index, maintain a window and pull left index
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    // Method2:
    // iterate left index, matina a window and push right index
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int right = 0;
        int product = 1;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && product < k) {
                product *= nums[right];
                right++;
            }
            res += product >= k ? right - 1 - left : right - left;
            if (product >= k) {
                product /= nums[left];
            }
        }
        return res;
    }
}