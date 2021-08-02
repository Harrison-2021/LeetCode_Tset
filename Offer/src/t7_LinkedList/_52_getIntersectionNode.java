package t7_LinkedList;

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
    	if(headA == null || headB == null) return null;
    	if(headA == headB) return headA;
    	
        // 查找两个链表相差的个数
    	ListNode pit1 = headA;
    	ListNode pit2 = headB;
    	
    	while(pit1 != null && pit2 != null) {
    		pit1 = pit1.next;
    		pit2 = pit2.next;
    	}
    	
    	// 让长的链表先查找k个，再与短的链表一同推进，当推进到同一个节点时，结束
    	// 返回该相同的节点
    	if(pit1 != null) {
    		return getIntersectionNode(pit2, pit1, headB, headA);
    	}
    	else {
    		return getIntersectionNode(pit1, pit2, headA, headB);
    	}	
    }
    
    private ListNode getIntersectionNode(ListNode shortPit, ListNode longPit, ListNode shortHead, ListNode longHead) {
    	int k = 0;
    	while(longPit != null) {
    		longPit = longPit.next;
			k ++;
		}
		
    	shortPit = shortHead;
		longPit = longHead;
		for(int i = 0; i < k; i ++) {
			longPit = longPit.next;
		}
		
		while(shortPit != longPit) {
			longPit = longPit.next;
			shortPit = shortPit.next;
		}
		return shortPit;
   }
}    
  





















