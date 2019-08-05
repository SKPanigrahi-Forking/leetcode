package stack;

import java.util.*;

/**
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Example:
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 */

class _084_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // store the idx
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int curH = i == len ? 0 : heights[i];
            while (!stack.isEmpty() && curH < heights[stack.peek()]) {
                int curLowestH = heights[stack.pop()];
                int preIdx = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, curLowestH * (i - preIdx - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}