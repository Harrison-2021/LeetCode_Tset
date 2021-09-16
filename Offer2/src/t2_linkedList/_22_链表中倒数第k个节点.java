package t2_linkedList;

import java.util.LinkedList;

/**
 * @author ls2690069470
 *     题目要求是返回以倒数k节点为头节点的链表
 */
public class _22_链表中倒数第k个节点 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	// 方法一、用辅助栈储存所有节点，再正序遍历即可
	public ListNode getKthFromEnd(ListNode head, int k) {
		LinkedList<ListNode> linked = new LinkedList<>();
		ListNode cur = head;
		
		while(cur != null) {
			linked.push(cur);
			cur = cur.next;
		}
		
		//cur = linked.peekFirst();  此时头节点的指针指向null，不能用此节点去遍历
		cur = linked.get(k - 1); // 可以用链表自带的方法获取特定位置的元素
		return cur;
	}
	
	// 方法二、利用双指针法，一快一慢，先拉开k个距离，再同步推进，前面的走到底，后面的正好就是要求的节点
	public ListNode getKthFromEnd2(ListNode head, int k) {
		ListNode front = head;
		ListNode back = head;
		
		for(int i = 0; i < k; i ++) {
			front = front.next; // 本题中给的条件不会越界，无需判断
		}
		
		while(front != null) {
			front = front.next;
			back = back.next;
		}
		
		return back;
	}
}
