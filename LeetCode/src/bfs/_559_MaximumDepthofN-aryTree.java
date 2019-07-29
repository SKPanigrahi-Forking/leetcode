package bfs;

import java.util.LinkedList;
import java.util.Queue;

class _559_MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            res++;
        }
        return res;
    }
}