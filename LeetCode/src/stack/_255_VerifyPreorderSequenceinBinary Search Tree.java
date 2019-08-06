package stack;

import java.util.*;

/**
 * 
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Consider the following binary search tree:
 * 
 * Example 1:
 * 
 * Input: [5,2,6,1,3] Output: false Example 2:
 * 
 * Input: [5,2,1,3,6] Output: true Follow up: Could you do it using only
 * constant space complexity?
 */

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int num : preorder) {
            while (!stack.isEmpty() && num > stack.peek()) {
                low = stack.pop();
            }
            if (num < low) {
                return false;
            }
            stack.push(num);
        }
        return true;
    }
}