package twoPointers;

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed.
 * 
 * Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output.
 * 
 * Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true
 * 
 * Example 4:
 * 
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals("")) {
            return typed.equals("");
        }
        int i = 0;
        int j = 0;
        int len1 = name.length();
        int len2 = typed.length();
        while (i < len1 && j < len2) {
            if (name.charAt(i) == typed.charAt(j)) {
                if (i == len1 - 1) {
                    return true;
                }
                i++;
                j++;
            } else {
                j++;
            }
        }
        return false;
    }
}