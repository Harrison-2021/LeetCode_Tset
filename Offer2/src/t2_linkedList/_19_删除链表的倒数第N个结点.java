package t2_linkedList;

public class _19_删除链表的倒数第N个结点 {
	class ListNode {
		public int val;
		public ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fron = dummyHead;
		ListNode back = dummyHead;

		for (int i = 0; i < n; i++) {
			fron = fron.next;
		}

		while (fron.next != null) {
			fron = fron.next;
			back = back.next;
		}

		back.next = back.next.next;

		return dummyHead.next;
	}
}
