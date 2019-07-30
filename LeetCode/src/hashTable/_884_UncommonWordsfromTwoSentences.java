package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given two sentences A and B. (A sentence is a string of space
 * separated words. Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words.
 * 
 * You may return the list in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = "this apple is sweet", B = "this apple is sour" Output:
 * ["sweet","sour"]
 * 
 * Example 2:
 * 
 * Input: A = "apple apple", B = "banana" Output: ["banana"]
 */

class _884_UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        if (A == null || B == null) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        String[] arr1 = A.split(" ");
        String[] arr2 = B.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : arr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : arr2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val == 1 && !map2.containsKey(key)) {
                list.add(key);
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val == 1 && !map1.containsKey(key)) {
                list.add(key);
            }
        }
        return list.toArray(new String[0]);
    }
}