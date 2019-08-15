package twoPointers;

/**
 * 
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * 
 * Example 2:
 * 
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 -10000 <= A[i] <= 10000 A is sorted in non-decreasing
 * order.
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        int idx = right;
        int[] res = new int[len];
        while (left <= right) {
            if (Math.abs(A[left]) > A[right]) {
                res[idx] = A[left] * A[left];
                left++;
            } else {
                res[idx] = A[right] * A[right];
                right--;
            }
            idx--;
        }
        return res;
    }
}