package heap;

import java.util.*;

/**
 * There are n cities connected by m flights. Each fight starts from city u and
 * arrives at v with a price w.
 * 
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 * 
 * Example 1: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] src = 0, dst
 * = 2, k = 1 Output: 200
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) {
                map.put(flights[i][0], new HashMap<>());
            }
            map.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, src, K + 1 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int priceSum = cur[0];
            int city = cur[1];
            int leftStops = cur[2];
            if (city == dst) {
                return priceSum;
            }
            if (leftStops > 0) {
                Map<Integer, Integer> neis = map.getOrDefault(city, new HashMap<>());
                for (int nei : neis.keySet()) {
                    pq.add(new int[] { priceSum + neis.get(nei), nei, leftStops - 1 });
                }
            }
        }
        return -1;
    }
}