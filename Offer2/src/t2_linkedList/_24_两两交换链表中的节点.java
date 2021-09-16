package t2_linkedList;

public class _24_�������������еĽڵ� {
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
		
		// ����ı�ָ���֮ǰָ��Ľڵ���Ҳ����ˣ���ˣ�Ҫ�Ƚ�֮ǰ�Ľڵ㱣������
		while(pre.next != null && pre.next.next != null) { // ��&&������||
			ListNode temp1 = pre.next; // pre.nextָ��ĵ�һ���ڵ�Ҫ�ı�
			ListNode temp2 = pre.next.next.next; // pre.next.next.next��ָ��Ľڵ�3Ҫ�ı�
			
			pre.next = pre.next.next;
			pre.next.next = temp1;
			temp1.next = temp2;
			
			pre = pre.next.next;
		}
		
		return dummyHead.next;
	}
}
