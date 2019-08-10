package heap;

import java.util.*;

/**
 * 
 * Given a non-empty string s and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: s = "aabbcc", k = 3 Output: "abcabc" Explanation: The same letters are
 * at least distance 3 from each other.
 * 
 * Example 2:
 * 
 * Input: s = "aaabc", k = 3 Output: "" Explanation: It is not possible to
 * rearrange the string.
 * 
 * Example 3:
 * 
 * Input: s = "aaadbbcc", k = 2 Output: "abacabcd" Explanation: The same letters
 * are at least distance 2 from each other.
 */
class Solution {
    public String rearrangeString(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> lockQueue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            // char with 0 count still needs to be placed in lockQueue as a place holder
            lockQueue.offer(cur);
            if (lockQueue.size() < k) {
                continue;
            }
            // release the char if it's k distance apart
            Map.Entry<Character, Integer> next = lockQueue.poll();
            if (next.getValue() > 0) {
                pq.offer(next);
            }
        }
        return sb.length() == len ? sb.toString() : "";
    }
}
