package t2_linkedList;

public class _707_设计链表 {
	class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode() {}
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	private int size;
	private ListNode dummyHead;
	/** Initialize your data structure here. */
    public _707_设计链表() {
    	dummyHead.next = new ListNode();
    	size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if(index < 0 || index >= size) {
    		return -1;
    	}
    	ListNode pre = dummyHead;
    	for(int i = 0; i < index; i ++) {
    		pre = pre.next;
    	}
    	
    	return pre.next.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index > size) {
    		return;
    	}
    	if(index < 0 ) index = 0;
    	
    	ListNode pre = dummyHead;
    	for(int i = 0; i < index; i ++) {
    		pre = pre.next;
    	}
    	// 为了防止忘记维护size，要在操作前维护size
    	size ++;
    	ListNode node = new ListNode(val);
    	node.next = pre.next; // 先断后
    	pre.next = node;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if(index < 0 || index >= size) {
    		return;
    	}
    	
    	ListNode pre = dummyHead;
    	for(int i = 0; i < index; i ++) {
    		pre = pre.next;
    	}
    	// 为了防止忘记维护size，要在操作前维护size
    	size --;
    	
    	pre.next = pre.next.next;
    }
}
