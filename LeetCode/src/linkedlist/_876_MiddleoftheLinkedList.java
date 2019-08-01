package linkedlist;

class _876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while ((right.next != null) && (right.next.next != null)) {
            left = left.next;
            right = right.next.next;
        }
        if (right.next == null) {
            return left;
        } else {
            return left.next;
        }
    }
}