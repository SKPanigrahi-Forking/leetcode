package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5 Output: 7
 *
 * Explanation: There are 7 subarrays with a sum divisible by K = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3],
 * [0], [0, -2, -3], [-2, -3]
 *
 * Note:
 *
 * 1 <= A.length <= 30000 -10000 <= A[i] <= 10000 2 <= K <= 10000
 */

class Main {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        if (A == null || A.length == 0 || K == 0) {
            return 0;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 0);
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        for (int i = 0; i < A.length; i++) {
            // be careful with the negative numbers
            int cur = (A[i] % K + K) % K;
            if (map.containsKey(cur)) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                res += map.get(cur);
            } else {
                map.put(cur, 0);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("x");
    }
}