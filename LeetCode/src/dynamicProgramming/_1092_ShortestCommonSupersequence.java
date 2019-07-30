package dynamicProgramming;

/**
 * Given two strings str1 and str2, return the shortest string that has both
 * str1 and str2 as subsequences. If multiple answers exist, you may return any
 * of them.
 *
 * (A string S is a subsequence of string T if deleting some number of
 * characters from T (possibly 0, and the characters are chosen anywhere from T)
 * results in the string S.)
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab" Output: "cabac"
 *
 *
 * Explanation:
 *
 * str1 = "abac" is a substring of "cabac" because we can delete the first "c".
 *
 * str2 = "cab" is a substring of "cabac" because we can delete the last "ac".
 *
 * The answer provided is the shortest such string that satisfies these
 * properties.
 *
 *
 * Note:
 *
 * 1 <= str1.length, str2.length <= 1000 str1 and str2 consist of lowercase
 * English letters.
 */

class _1092_ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        String res = "";
        int len1 = str1.length();
        int len2 = str2.length();
        // build the Longest commen subsequence
        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = len1;
        int j = len2;
        while (i >= 0 && j >= 0) {
            if (i == 0) {
                res = str2.substring(0, j) + res;
                break;
            } else if (j == 0) {
                res = str1.substring(0, i) + res;
                break;
            } else if (arr1[i - 1] == arr2[j - 1]) {
                res = "" + arr1[i - 1] + res;
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                res = "" + arr1[i - 1] + res;
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                res = "" + arr2[j - 1] + res;
                j--;
            }
        }
        return res;
    }
}