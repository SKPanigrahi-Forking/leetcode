package hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
 * strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4
 * times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"] Output: ["e","l","l"]
 *
 * Example 2:
 *
 * Input: ["cool","lock","cook"] Output: ["c","o"]
 */
public class _1002_FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int[] map = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            map[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                cur[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (cur[j] < map[j]) {
                    map[j] = cur[j];
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i]; j++) {
                res.add("" + (char) ('a' + i));
            }
        }
        return res;
    }
}
