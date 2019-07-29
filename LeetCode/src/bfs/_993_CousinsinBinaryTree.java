package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * 
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * 
 */
class _993_CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean existx = false;
            boolean existy = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x)
                    existx = true;
                if (cur.val == y)
                    existy = true;
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x && cur.right.val == y) || cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            if (existx && existy)
                return true;
            if (existx || existy)
                return false;
        }
        return false;
    }
}
