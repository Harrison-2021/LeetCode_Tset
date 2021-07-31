package t7_LinkedList;


public class _22_getKthFromEnd {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// 快慢双指针，拉开k的距离
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode front = head;
		ListNode back = head;
		for(int i = 0; i < k; i ++) {
			if(front == null) { // 注意边界问题，即k大于链表元素情况
				return null;
			}
			front = front.next;
		}
		
		while(front != null) {
			front = front.next;
			back = back.next;
		}
		
		return back;
    }
}
