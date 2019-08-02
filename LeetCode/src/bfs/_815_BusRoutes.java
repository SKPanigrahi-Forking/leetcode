package bfs;

import java.util.*;

/**
 * 
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus
 * repeats forever. For example if routes[0] = [1, 5, 7], this means that the
 * first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->...
 * forever.
 * 
 * We start at bus stop S (initially not on a bus), and we want to go to bus
 * stop T. Travelling by buses only, what is the least number of buses we must
 * take to reach our destination? Return -1 if it is not possible.
 * 
 * Example: Input: routes = [[1, 2, 7], [3, 6, 7]] S = 1 T = 6 Output: 2
 * 
 * Explanation: The best strategy is take the first bus to the bus stop 7, then
 * take the second bus to the bus stop 6. Note:
 * 
 * 1 <= routes.length <= 500. 1 <= routes[i].length <= 500. 0 <= routes[i][j] <
 * 10 ^ 6.
 * 
 */

class _815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T)
            return 0;
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                List<Integer> list = map.getOrDefault(station, new ArrayList<>());
                list.add(i);
                map.put(station, list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(S);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int curStation = queue.poll();
                List<Integer> curBuses = map.get(curStation);
                for (int j = 0; j < curBuses.size(); j++) {
                    int curBus = curBuses.get(j);
                    if (visited.contains(curBus)) {
                        continue;
                    }
                    visited.add(curBus);
                    for (int k = 0; k < routes[curBus].length; k++) {
                        if (routes[curBus][k] == T) {
                            return res;
                        }
                        queue.offer(routes[curBus][k]);
                    }
                }
            }
        }
        return -1;
    }
}