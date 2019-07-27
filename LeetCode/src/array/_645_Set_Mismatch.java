package array;

/**
 * 
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 * 
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number
 * that is missing. Return them in the form of an array.
 * 
 * Example 1: Input: nums = [1,2,2,4] Output: [2,3]
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int dup = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int diff = len * (len + 1) / 2 - sum;
        for (int i = 0; i < len; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                dup = Math.abs(nums[i]);
                break;
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return new int[] { dup, dup + diff };
    }
}