package t7_LinkedList;

import java.util.LinkedList;

public class _6_reversePrint {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	public int[] reversePrint(ListNode head) {
		ListNode cur = head;
		LinkedList<ListNode> linked = new LinkedList<>();
				
		while(cur != null) {
			linked.push(cur);
			cur = cur.next;
		}
		
		int[] arr = new int[linked.size()];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = linked.pop().val;
		}
		
		return arr;
    }
	
}
