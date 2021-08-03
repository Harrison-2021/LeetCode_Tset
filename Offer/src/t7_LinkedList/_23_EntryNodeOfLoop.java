package t7_LinkedList;

import java.util.*;

/**
 * @author ls2690069470
 *	 链表中环的入口结点
 */
public class _23_EntryNodeOfLoop {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	// hashTable
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		//if(pHead == null) return null;
		
        Set<ListNode> set = new HashSet<>();
        while(pHead != null) {
        	if(set.contains(pHead)) {
        		return pHead;
        	} else {
        		set.add(pHead);
        	}
        	
        	pHead = pHead.next;
        }
        
        return null;
    }
	
	// 快慢双指针，拉开距离，再根据距离进行逼近找到目标节点
	public ListNode EntryNodeOfLoop2(ListNode pHead) {
		//if(pHead == null) return null;
		
		ListNode fast = pHead;
		ListNode slow = pHead;
		
		// 找到第一次相遇点
		while(fast != null && fast.next != null) { // 相等不能作为循环终止条件，因为初始旧相等
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) break; // 用break也可终止循环
		}
		// 排除不是环形链表情况
		if(fast == null || fast.next == null) return null;
		
		// s = m + (n -1)*(m + d),从头节点，相遇点两头逼近，一定会在目标节点汇合
		fast = pHead;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
}








