package t2_linkedList;

import java.util.HashSet;
import java.util.Set;

public class _22_2_链表中环的入口节点 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	// 链表中内嵌环形链表，链表尾部一定指向头部，这样头部链表就会出现两次，可以用哈希表，集合来处理重复的数
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {
			if(set.contains(head)) {
				return head;
			} else {
				set.add(head);
			}
			head = head.next;
		}
		
		return null;
	}
	
	// 双指针法
	// 找到第一次相遇点
	// fast走两步，slow走一步，当slow走在前面时候，每走一次，差距减1，最终差距减为0，相遇
	// 还要排除没有环的情况，那第一次就不会相遇，fast会一直走到链尾
	// 链表头到环入口处节点数为a，环中节点数为b，fast走了f，slow走了s，有f=s+nb,f=2s==>s=nb
	// 从头到环入口，a+nb,s=nb,故，slow再走a即可到达环入口
	// 为了统计a，再用双指针，从头部与slow同时出发，头到入口正好为a，即再次相遇时，两者都走了a
	// s = m + (n -1)*(m + d),从头节点，相遇点两头逼近，一定会在目标节点汇合
	public ListNode detectCycle2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) { // 因为fast一次调两步，有fast.next.next,要先判断fast.next!=null
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) break;
		}
		
		if(fast == null || fast.next == null) {
			return null;
		}
		
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
	
}
