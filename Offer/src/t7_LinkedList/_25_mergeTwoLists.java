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
		// 引用虚拟头节点可以简化代码
		ListNode dummyHead = new ListNode(0);
		ListNode prePrt = dummyHead;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				prePrt.next = l1;
				l1 = l1.next;
			} else {
				prePrt.next = l2;
				l2 = l2.next;
			}
			prePrt = prePrt.next;	
		}
		
		// 最后要连接上剩下的元素
		prePrt.next = (l1 != null ? l1 : l2);
		
		return dummyHead.next;
    }
	
}
