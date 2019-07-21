/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1: Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 *
 * Example 2: Input: "cbbd" Output: "bb"
 */
class _005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int len = s.length();
        int max = 0;
        String res = "";
        // dp[i][j] indicates if s.substring(i, j) is palindromic
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&
                        (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}