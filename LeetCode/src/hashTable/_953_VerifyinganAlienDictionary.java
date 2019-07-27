package hashTable;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The
 * order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 *
 * Output: true Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 *
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz" Output: false Explanation: As 'd' comes
 * after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 */
public class _953_VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i + 'a';
        }
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append((char) map[c - 'a']);
            }
            words[i] = sb.toString();
        }
        for (int i = 1; i < words.length; i++) {
            if ((words[i].compareTo(words[i - 1])) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted2(String[] words, String order) {
            if (words == null || words.length == 0) {
                return true;
            }
            int[] map = new int[26];
            for (int i = 0; i < order.length(); i++) {
                map[order.charAt(i) - 'a'] = i + 'a';
            }
            for (int i = 1; i < words.length; i++) {
                if (!compare(words[i - 1], words[i], map)) {
                    return false;
                }
            }
            return true;
        }

        private boolean compare(String s1, String s2, int[] map) {
            int len1 = s1.length();
            int len2 = s2.length();
            int i = 0;
            while (i < len1 && i < len2) {
                if (map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a']) {
                    return false;
                } else if (map[s1.charAt(i) - 'a'] < map[s2.charAt(i) - 'a']) {
                    return true;
                }
                i++;
            }
            // ["apple","app"]
            if (i == len2) {
                return false;
            }
            return true;
        }
}
