package twoPointers;

import java.util.*;

/**
 * A string S of lowercase letters is given. We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * Example 1: Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so
 * that each letter appears in at most one part. A partition like
 * "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less
 * parts. Note:
 * 
 * S will have length in range [1, 500]. S will consist of lowercase letters
 * ('a' to 'z') only.
 */

class _763_PartitionLabels {
    public List<Integer> partitionLabels1(String S) {
        int[] map = new int[26];
        int[] set = new int[26];
        int left = -1;
        int right = 0;
        int len = S.length();
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            map[S.charAt(i) - 'a']++;
        }
        while (right < len) {
            char c = S.charAt(right);
            if (set[c - 'a'] == 0) {
                cnt += map[c - 'a'];
            }
            cnt--;
            if (cnt == 0) {
                res.add(right - left);
                left = right;
            }
            set[c - 'a'] = 1;
            right++;
        }
        return res;
    }

    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new ArrayList<>();
        int len = S.length();
        int[] lastLoc = new int[26];
        for (int i = 0; i < len; i++) {
            lastLoc[S.charAt(i) - 'a'] = i;
        }
        int last = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            last = Math.max(last, lastLoc[S.charAt(i) - 'a']);
            if (i == last) {
                res.add(i - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}