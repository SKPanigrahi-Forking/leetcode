package twoPointers;

/**
 * 
 * Example 1:
 * 
 * Input: ".L.R...LR..L.."
 * 
 * Output: "LL.RR.LLRRLL.."
 * 
 * Example 2:
 * 
 * Input: "RR.L"
 * 
 * Output: "RR.L"
 * 
 * Explanation: The first domino expends no additional force on the second
 * domino.
 * 
 * 
 * 'R......R' => 'RRRRRRRR'
 * 
 * 'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
 * 
 * 'L......R' => 'L......R'
 * 
 * 'L......L' => 'LLLLLLLL'
 * 
 */

class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        StringBuilder res = new StringBuilder();
        int left = 0;
        for (int right = 1; right < dominoes.length(); right++) {
            if (dominoes.charAt(right) == '.') {
                continue;
            }
            if (left > 0) {
                res.append(dominoes.charAt(left));
            }
            int gap = right - left - 1;
            // 'R......R' => 'RRRRRRRR' OR 'L......L' => 'LLLLLLLL'
            if (dominoes.charAt(left) == dominoes.charAt(right)) {
                for (int i = 0; i < gap; i++) {
                    res.append(dominoes.charAt(left));
                }
            }
            // 'L......R' => 'L......R'
            if (dominoes.charAt(left) == 'L' && dominoes.charAt(right) == 'R') {
                for (int i = 0; i < gap; i++) {
                    res.append('.');
                }
            }
            // 'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
            if (dominoes.charAt(left) == 'R' && dominoes.charAt(right) == 'L') {
                for (int i = 0; i < gap / 2; i++) {
                    res.append('R');
                }
                if (gap % 2 == 1) {
                    res.append('.');
                }
                for (int i = 0; i < gap / 2; i++) {
                    res.append('L');
                }
            }
            left = right;
        }
        return res.toString();
    }
}
