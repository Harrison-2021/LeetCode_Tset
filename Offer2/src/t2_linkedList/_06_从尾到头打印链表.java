package t2_linkedList;

import java.util.LinkedList;

public class _06_从尾到头打印链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// 倒序打印，可以用辅助栈的进出来改变顺序
	public int[] reversePrint(ListNode head) {
		ListNode cur = head;
		LinkedList<ListNode> linked = new LinkedList<>();
		
		while(cur != null) {
			linked.addFirst(cur);
			cur = cur.next;
		}
		
		int[] res = new int[linked.size()];
		for(int i = 0; i < res.length; i ++) {
			res[i] = linked.remove().val;
		}
		
		return res;
	}
	
	// 使用递归法,递归的实质也是栈，即先递归到底，
	// 即先处理递归深处问题，正好先处理尾部，再处理头部，实现倒序 
	LinkedList<ListNode> set = new LinkedList<>();
	public int[] reversePrint2(ListNode head) {
		recure(head);
		int[] res = new int[set.size()];
		for(int i = 0; i < res.length; i ++) {
			res[i] = set.remove().val;
		}
		return res;
	}
	private void recure(ListNode node) {
		if(node == null) return;
		
		recure(node.next);
		set.addLast(node);		
	}
}
