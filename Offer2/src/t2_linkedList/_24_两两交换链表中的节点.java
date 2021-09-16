package t2_linkedList;

public class _24_两两交换链表中的节点 {
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

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		
		// 如果改变指向后，之前指向的节点就找不到了，因此，要先将之前的节点保存下来
		while(pre.next != null && pre.next.next != null) { // 是&&，不是||
			ListNode temp1 = pre.next; // pre.next指向的第一个节点要改变
			ListNode temp2 = pre.next.next.next; // pre.next.next.next。指向的节点3要改变
			
			pre.next = pre.next.next;
			pre.next.next = temp1;
			temp1.next = temp2;
			
			pre = pre.next.next;
		}
		
		return dummyHead.next;
	}
}
