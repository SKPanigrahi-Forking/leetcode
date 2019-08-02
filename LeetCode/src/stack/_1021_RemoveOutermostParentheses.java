package stack;

import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string
 * concatenation. For example, "", "()", "(())()", and "(()(()))" are all valid
 * parentheses strings.
 * 
 * A valid parentheses string S is primitive if it is nonempty, and there does
 * not exist a way to split it into S = A+B, with A and B nonempty valid
 * parentheses strings.
 * 
 * Given a valid parentheses string S, consider its primitive decomposition: S =
 * P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * 
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "(()())(())" Output: "()()()" Explanation: The input string is
 * "(()())(())", with primitive decomposition "(()())" + "(())". After removing
 * outer parentheses of each part, this is "()()" + "()" = "()()()".
 * 
 * Example 2:
 * 
 * Input: "(()())(())(()(()))" Output: "()()()()(())" Explanation: The input
 * string is "(()())(())(()(()))", with primitive decomposition "(()())" +
 * "(())" + "(()(()))". After removing outer parentheses of each part, this is
 * "()()" + "()" + "()(())" = "()()()()(())".
 * 
 * Example 3:
 * 
 * Input: "()()" Output: "" Explanation: The input string is "()()", with
 * primitive decomposition "()" + "()". After removing outer parentheses of each
 * part, this is "" + "" = "".
 * 
 * 
 * Note:
 * 
 * S.length <= 10000 S[i] is "(" or ")" S is a valid parentheses string
 */
class _1021_RemoveOutermostParentheses {

    // method 1: stack
    public String removeOuterParentheses1(String S) {
        if (S == null || S.equals("")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push('(');
            } else {
                stack.pop();
            }
            if (i != 0 && stack.isEmpty()) {
                sb.append(S.substring(left + 1, i));
                left = i + 1;
            }
        }
        return sb.toString();
    }

    // method 2
    public String removeOuterParentheses2(String S) {
        if (S == null || S.equals("")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        char[] chars = S.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                opened++;
            } else {
                opened--;
            }
            if (i != 0 && opened == 0) {
                sb.append(S.substring(left + 1, i));
                left = i + 1;
            }
        }
        return sb.toString();
    }

    // method 3
    public String removeOuterParentheses3(String S) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) {
                sb.append(c);
            }
            if (c == ')' && opened-- > 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}