package t2_linkedList;

import java.util.HashSet;
import java.util.Set;

public class _52_两个链表的第一个公共节点 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// 方法一、循环记步法
	// headA: a + c, headB: b + c => a+c+b = b+c+a,每条链表走这么多步，一定最终走的一样多，相交
	// 即当两链表相交，只要两链表走了a+c+b = b+c+a步，一定到达相同节点，否则都指向空，返回空
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode pitA = headA;
		ListNode pitB = headB;
		
		while(pitA != pitB) {
			pitA = pitA != null ? pitA.next : headB;
			pitB = pitB != null ? pitB.next : headA;
		}
		
		return pitA;
	}
	
	// 哈希表法，解决链表不易查询的问题
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode cur = headA;
		
		while(cur != null) {
			set.add(cur);
			cur = cur.next;
		}
		
		cur = headB;
		while(cur != null) {
			if(set.contains(cur)) {
				return cur;
			}
			cur = cur.next;
		}
		
		return null;
	}
}
