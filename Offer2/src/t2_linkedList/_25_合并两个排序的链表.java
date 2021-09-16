package t2_linkedList;

public class _25_合并两个排序的链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// 引用虚拟头节点可以简化代码
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode pre = dummyHead;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			
			pre = pre.next;
		}
		
		pre.next = (l1 != null ? l1 : l2);
		
		return dummyHead.next;
	}
}
