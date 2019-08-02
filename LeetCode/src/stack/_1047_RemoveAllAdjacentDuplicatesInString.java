package stack;

import java.util.Stack;;

/**
 * 
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * Input: "abbaca" Output: "ca" Explanation: For example, in "abbaca" we could
 * remove "bb" since the letters are adjacent and equal, and this is the only
 * possible move. The result of this move is that the string is "aaca", of which
 * only "aa" is possible, so the final string is "ca".
 * 
 * Example 2:
 * 
 *  "abbbaca" Output: "abaca"
 * 
 * Note:
 * 
 * 1 <= S.length <= 20000 S consists only of English lowercase letters.
 * 
 * 
 */
class _1047_RemoveAllAdjacentDuplicatesInString {
    // method 1: stack
    public String removeDuplicates1(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    //method 2: StringBuilder
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int len = sb.length();
            if (len != 0 && c == sb.charAt(len - 1)) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}