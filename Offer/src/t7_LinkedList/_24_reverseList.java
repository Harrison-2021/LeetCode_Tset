package t7_LinkedList;

public class _24_reverseList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode left = null;
		ListNode mid = head;
		ListNode right = mid.next;
				
		while(mid != null) {
			mid.next = left;
			left = mid;
			mid = right;
			if(right != null) {
				right = right.next;
			}
		}
		
		return left;
    }
}
