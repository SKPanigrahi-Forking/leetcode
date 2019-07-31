package linkedlist;

/**
 * 
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the
 * left and right pointers as synonymous to the previous and next pointers in a
 * doubly-linked list.
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    private Node start = null;
    private Node end = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        helper(root);
        start.left = end;
        end.right = start;
        return start;
    }

    private void helper(Node node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (end != null) {
            end.right = node;
            node.left = end;
        } else {
            start = node;
        }
        end = node;
        helper(node.right);
    }
}