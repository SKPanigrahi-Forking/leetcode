package heap;

import java.util.*;

/**
 * 
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal. You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * Example 1:
 * 
 * Input: [1,1,1,2,2,2] Output: [2,1,2,1,2,1]
 * 
 * Example 2:
 * 
 * Input: [1,1,1,1,2,2,3,3] Output: [1,3,1,3,2,1,2,1]
 * 
 * Note:
 * 
 * 1 <= barcodes.length <= 10000 1 <= barcodes[i] <= 10000
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] res = new int[barcodes.length];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> first = pq.poll();
            if (idx == 0 || res[idx - 1] != first.getKey()) {
                res[idx++] = first.getKey();
                if (first.getValue() > 1) {
                    first.setValue(first.getValue() - 1);
                    pq.offer(first);
                }
            } else {
                Map.Entry<Integer, Integer> second = pq.poll();
                res[idx++] = second.getKey();
                if (second.getValue() > 1) {
                    second.setValue(second.getValue() - 1);
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }
        return res;
    }
}