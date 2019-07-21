/**
 *
 */
class _647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return res;
    }
}