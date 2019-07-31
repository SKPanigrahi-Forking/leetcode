package linkedlist;

/**
 * 
 * Problem:
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 */
public class _021_MergeTwoSortedLinkedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					cur.next = l1;
					l1 = l1.next;
				} else {
					cur.next = l2;
					l2 = l2.next;
				}
				cur = cur.next;
			}
			if (l1 == null) {
				cur.next = l2;
				break;
			}
			if (l2 == null) {
				cur.next = l1;
				break;
			}
		}
		return dummy.next;
	}
}