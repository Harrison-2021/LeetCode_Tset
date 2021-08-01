package t7_LinkedList;

public class _25_mergeTwoLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode newHead = null;
		ListNode prePrt = null;
		ListNode prt1 = l1;
		ListNode prt2 = l2;
		if(l1.val < l2.val) {
			newHead = l1;
			prt1 = l1.next; 
		} else {
			newHead = l2;
			prt2 = l2.next;
		}
		prePrt = newHead;
			
		while(prt1 != null && prt2 != null) {
			if(prt1.val < prt2.val) {
				prePrt.next = prt1;
				prt1 = prt1.next;
			} else {
				prePrt.next = prt2;
				prt2 = prt2.next;
			}
			prePrt = prePrt.next;			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		}
		return newHead;
    }
	
}
