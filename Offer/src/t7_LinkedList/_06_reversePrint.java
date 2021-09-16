package t7_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class _06_reversePrint {
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
		// 用一个双向列表实现栈的功能，一直从头开始加，先进后出的特性
		LinkedList<ListNode> linked = new LinkedList<>();
				
		while(cur != null) {
			linked.push(cur); // 等价于addFirst()
			cur = cur.next;
		}
		
		int[] arr = new int[linked.size()];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = linked.pop().val;
		}
		
		return arr;
    }
	
	// 使用递归法,递归的实质也是栈，即先递归到底，即先处理递归深处问题，正好先处理尾部，再处理头部，实现倒序
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
