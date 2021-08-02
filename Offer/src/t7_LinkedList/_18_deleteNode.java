package t7_LinkedList;

public class _18_deleteNode {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	 public ListNode deleteNode(ListNode head, int val) {
		 ListNode dummyHead = new ListNode(0);
		 dummyHead.next = head;
		 ListNode pre = dummyHead;
		 
		 while(pre.next.val != val && pre.next != null) {
			 pre = pre.next;
		 }
		 
		 if(pre.next != null) {
			 pre.next = pre.next.next;
		 }
		 
		 return dummyHead.next;
	 }
}
