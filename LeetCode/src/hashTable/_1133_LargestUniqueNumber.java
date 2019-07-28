package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers A, return the largest integer that only occurs
 * once.
 * 
 * If no integer occurs once, return -1.
 * 
 */
class Solution {
    public int largestUniqueNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) {
                res = Math.max(res, key);
            }
        }
        return res;
    }
}