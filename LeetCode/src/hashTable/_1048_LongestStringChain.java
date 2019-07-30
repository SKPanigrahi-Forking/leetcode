package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a list of words, each word consists of English lowercase letters.
 * 
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly
 * one letter anywhere in word1 to make it equal to word2. For example, "abc" is
 * a predecessor of "abac".
 * 
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >=
 * 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of
 * word_3, and so on.
 * 
 * Return the longest possible length of a word chain with words chosen from the
 * given list of words.
 * 
 * Example 1:
 * 
 * Input: ["a","b","ba","bca","bda","bdca"] Output: 4
 * 
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 * 
 * Note:
 * 
 * 1 <= words.length <= 1000
 * 
 * 1 <= words[i].length <= 16
 * 
 * words[i] only consists of English lowercase letters.
 */
class _1048_LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays
        .sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String s : words) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                String prev = s.substring(0, i) + s.substring(i + 1);
                cur = Math.max(cur, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(s, cur);
            res = Math.max(res, cur);
        }
        return res;
    }
}