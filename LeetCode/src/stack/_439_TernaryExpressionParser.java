package stack;

import java.util.*;

/**
 * 
 * Given a string representing arbitrarily nested ternary expressions, calculate
 * the result of the expression. You can always assume that the given expression
 * is valid and only consists of digits 0-9, ?, :, T and F (T and F represent
 * True and False respectively).
 * 
 * Note:
 * 
 * The length of the given string is ≤ 10000. Each number will contain only one
 * digit. The conditional expressions group right-to-left (as usual in most
 * languages). The condition will always be either T or F. That is, the
 * condition will never be a digit. The result of the expression will always
 * evaluate to either a digit 0-9, T or F. Example 1:
 * 
 * Input: "T?2:3"
 * 
 * Output: "2"
 * 
 * Explanation: If true, then result is 2; otherwise result is 3.
 */
class _439_TernaryExpressionParser {
    public String parseTernary(String expression) {
        if (expression == null || expression.equals("")) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        int len = expression.length();
        for (int i = len - 1; i >= 0; i--) {
            char cur = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();
                if (cur == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {   // easy to forget else
                stack.push(expression.charAt(i));
            }
        }
        return "" + stack.peek();
    }
}