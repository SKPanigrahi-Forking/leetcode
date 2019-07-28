package hashTable;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Given an array of integers A with even length, return true if and only if it
 * is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0
 * <= i < len(A) / 2.
 * 
 * Example 1:
 * 
 * Input: [3,1,3,6] Output: false
 * 
 * Example 2:
 * 
 * Input: [2,1,2,6] Output: false
 * 
 * Example 3:
 * 
 * Input: [4,-2,2,-4] Output: true Explanation: We can take two groups, [-2,-4]
 * and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 */
class _954_ArrayofDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int a : A) {
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        for (int key : treeMap.keySet()) {
            if (treeMap.get(key) == 0)
                continue;
            int targ = key < 0 ? key / 2 : key * 2;
            if (key < 0 && key % 2 != 0 || treeMap.get(key) > treeMap.getOrDefault(targ, 0)) {
                return false;
            }
            treeMap.put(targ, treeMap.get(targ) - treeMap.get(key));
        }
        return true;
    }
}