package stack;

import java.util.*;

/**
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 * 
 * () has score 1 AB has score A + B, where A and B are balanced parentheses
 * strings. (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * Example 1:
 * 
 * Input: "()" Output: 1
 * 
 * Example 2:
 * 
 * Input: "(())" Output: 2
 * 
 * Example 3:
 * 
 * Input: "()()" Output: 2
 * 
 * Example 4:
 * 
 * Input: "(()(()))" Output: 6
 * 
 * Note:
 * 
 * S is a balanced parentheses string, containing only ( and ). 2 <= S.length <=
 * 50
 */
class _856_ScoreofParentheses {
    public int scoreOfParentheses1(String S) {
        Stack<Integer> stack = new Stack<>();
        // pre sum
        int preSum = 0;
        stack.push(preSum);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int cur = stack.pop();
                preSum = stack.pop();
                stack.push(preSum + Math.max(2 * cur, 1));
            }
        }
        return stack.pop();
    }

    public int scoreOfParentheses2(String S) {
        int res = 0;
        int opened = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                opened++;
            } else {
                opened--;
            }
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                res += 1 << opened;
            }
        }
        return res;
    }
}