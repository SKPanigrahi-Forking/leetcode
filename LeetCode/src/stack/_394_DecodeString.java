package stack;

import java.util.*;

/**
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * 
 * s = "3[a2[c]]", return "accaccacc".
 * 
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".ß
 */
class _394_DecodeString {
    public String decodeString(String s) {
        Stack<Integer> counter = new Stack<>();
        Stack<StringBuilder> sb = new Stack<>();
        StringBuilder curSb = new StringBuilder();
        int curCnt = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                curCnt = curCnt * 10 + c - '0';
            } else if (c == '[') {
                counter.push(curCnt);
                sb.push(curSb);
                curSb = new StringBuilder();
                curCnt = 0;
            } else if (c == ']') {
                StringBuilder tmp = curSb;
                curSb = sb.pop();
                for (int i = counter.pop(); i > 0; i--) {
                    curSb.append(tmp);
                }
            } else {
                curSb.append(c);
            }
        }
        return curSb.toString();
    }
}