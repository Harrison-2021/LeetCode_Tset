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
		
}








