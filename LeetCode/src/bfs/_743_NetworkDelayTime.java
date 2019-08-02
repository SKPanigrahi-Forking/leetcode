package bfs;

import java.util.*;

/**
 * 
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 */
class _743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            List<int[]> list = map.getOrDefault(time[0], new ArrayList<int[]>());
            list.add(new int[] { time[1], time[2] });
            map.put(time[0], list);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[] { K, 0 });
        boolean[] visited = new boolean[N];
        int curDist = 0;
        int numVisited = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!visited[cur[0] - 1]) {
                numVisited++;
                visited[cur[0] - 1] = true;
                curDist = cur[1];
                if (map.containsKey(cur[0])) {
                    for (int[] next : map.get(cur[0])) {
                        if (!visited[next[0] - 1]) {
                            pq.offer(new int[] { next[0], curDist + next[1] });
                        }
                    }
                }
            }
        }
        return numVisited == N ? curDist : -1;
    }
}