package t7_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class _6_reversePrint {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// 使用辅助栈
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
	
	// 使用递归法
	ArrayList<ListNode> set = new ArrayList<>();
	public int[] reversePrint2(ListNode head) {
		recure(head);
		
		int[] arr = new int[set.size()];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = set.get(i).val;
		}
		
		return arr;
	}
	
	private void recure(ListNode node) {
		if(node == null) return;
		
		recure(node.next);
		set.add(node);
	}
	
}
