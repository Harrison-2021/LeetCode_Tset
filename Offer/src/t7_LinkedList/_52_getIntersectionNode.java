package t7_LinkedList;

import java.util.*;

public class _52_getIntersectionNode {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	// headA: a + c, headB: b + c => a+c+b = b+c+a,
    	// 即当两链表相交，只要两链表走了这么多步，一定到达相同节点，否则都指向空，返回空
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
    	//if(headA == null || headB == null) return null;
    	//if(headA == headB) return headA;
    	
    	// 因为两链表可能长短不一，不适合用映射，而是单数据的集合比较合适
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
  





















