package heap;

import java.util.*;

/**
 * 
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba"
 * 
 * Example 2:
 * 
 * Input: S = "aaab" Output: "" Note:
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 */
class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (len + 1) / 2) {
                return "";
            }
            map.put(c, count);
        }
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> first = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first.getKey()) {
                sb.append(first.getKey());
                if (first.getValue() > 1) {
                    first.setValue(first.getValue() - 1);
                    pq.offer(first);
                }
            } else {
                Map.Entry<Character, Integer> second = pq.poll();
                sb.append(second.getKey());
                if (second.getValue() > 1) {
                    second.setValue(second.getValue() - 1);
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }
        return sb.toString();
    }
}