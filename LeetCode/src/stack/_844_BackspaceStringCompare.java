package stack;

import java.util.*;

/**
 * 
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac".
 * 
 * Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "".
 * 
 * Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c".
 * 
 * Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b". Note:
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters. Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 */

class _844_BackspaceStringCompare {

    // Method 1: stack
    public boolean backspaceCompare1(String S, String T) {
        return getFinal(S).equals(getFinal(T));
    }

    private String getFinal(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    // Method 2: two pointers
    public boolean backspaceCompare2(String S, String T) {
        if (S == null || T == null) {
            return false;
        }
        int len1 = S.length() - 1;
        int len2 = T.length() - 1;
        int numS = 0;
        int numT = 0;
        while (len1 >= 0 || len2 >= 0) {
            while (len1 >= 0) {
                if (S.charAt(len1) == '#') {
                    numS++;
                    len1--;
                } else if (numS > 0) {
                    numS--;
                    len1--;
                } else {
                    break;
                }
            }
            while (len2 >= 0) {
                if (T.charAt(len2) == '#') {
                    numT++;
                    len2--;
                } else if (numT > 0) {
                    numT--;
                    len2--;
                } else {
                    break;
                }
            }
            if (len1 >= 0 && len2 >= 0 && S.charAt(len1) != T.charAt(len2)) {
                return false;
            }
            if (len1 >= 0 != len2 >= 0) {
                return false;
            }
            len1--;
            len2--;
        }
        return true;
    }
}