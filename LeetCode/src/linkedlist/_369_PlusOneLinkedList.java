package linkedlist;

public class _369_PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // i record the most siginificant node
        ListNode node = dummy;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val != 9) {
                node = cur;
            }
        }
        if (cur.val != 9) {
            cur.val++;
        } else {
            node.val++;
            node = node.next;
            // set all the node after significatn node to be 0
            while (node != null) {
                node.val = 0;
                node = node.next;
            }
        }
        if (dummy.val == 0) {
            return dummy.next;
        }
        // 9 -> 9 -> 9
        return dummy;
    }
}