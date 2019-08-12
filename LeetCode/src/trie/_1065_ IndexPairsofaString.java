package trie;

import java.util.*;

/**
 * 
 * Given a text string and words (a list of strings), return all index pairs [i,
 * j] so that the substring text[i]...text[j] is in the list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 * 
 * Example 2:
 * 
 * Input: text = "ababa", words = ["aba","ab"] Output: [[0,1],[0,2],[2,3],[2,4]]
 * Explanation: Notice that matches can overlap, see "aba" is found in [0,2] and
 * [2,4].
 * 
 * 
 * Note:
 * 
 * All strings contains only lowercase English letters. It's guaranteed that all
 * strings in words are different. 1 <= text.length <= 100 1 <= words.length <=
 * 20 1 <= words[i].length <= 50 Return the pairs [i,j] in sorted order (i.e.
 * sort them by their first coordinate in case of ties sort them by their second
 * coordinate).
 * 
 */
class Solution {
    class TrieNode {
        private TrieNode[] children;
        public boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        // index is used to iterate the whole string word recursion
        public void insert(String word, int index) {
            // empty string
            if (index == word.length()) {
                this.isEnd = true;
                return;
            }
            int pos = word.charAt(index) - 'a';
            if (children[pos] == null) {
                children[pos] = new TrieNode();
            }
            children[pos].insert(word, index + 1);
        }
    }

    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word, 0);
        }
        for (int i = 0; i < text.length(); i++) {
            TrieNode cur = root;
            int end = i;
            char c = text.charAt(i);
            while (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
                if (cur.isEnd) {
                    list.add(new int[] { i, end });
                }
                end++;
                if (end == text.length()) {
                    break;
                } else {
                    c = text.charAt(end);

                }
            }
        }
        int len = list.size();
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}