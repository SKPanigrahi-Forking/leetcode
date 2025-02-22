package twoPointers;

/**
 * You are given a circular array nums of positive and negative integers. If a
 * number k at an index is positive, then move forward k steps. Conversely, if
 * it's negative (-k), move backward k steps. Since the array is circular, you
 * may assume that the last element's next element is the first element, and the
 * first element's previous element is the last element.
 * 
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end
 * at the same index and the cycle's length > 1. Furthermore, movements in a
 * cycle must all follow a single direction. In other words, a cycle must not
 * consist of both forward and backward movements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [2,-1,1,2,2] Output: true Explanation: There is a cycle, from index 0
 * -> 2 -> 3 -> 0. The cycle's length is 3.
 * 
 * Example 2:
 * 
 * Input: [-1,2] Output: false Explanation: The movement from index 1 -> 1 -> 1
 * ... is not a cycle, because the cycle's length is 1. By definition the
 * cycle's length must be greater than 1.
 * 
 * Example 3:
 * 
 * Input: [-2,1,-1,-2,-2] Output: false Explanation: The movement from index 1
 * -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a
 * forward movement, but movement from index 2 -> 1 is a backward movement. All
 * movements in a cycle must follow a single direction.
 */
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = getNextIdx(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[getNextIdx(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    // one element in the loop
                    if (slow == getNextIdx(slow, nums)) {
                        break;
                    }
                    return true;
                }
                slow = getNextIdx(slow, nums);
                fast = getNextIdx(getNextIdx(fast, nums), nums);
            }
            // set element to be 0 to decrease unnecessary setps
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getNextIdx(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int getNextIdx(int i, int[] nums) {
        int len = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % len : len + ((i + nums[i]) % len);
    }
}
