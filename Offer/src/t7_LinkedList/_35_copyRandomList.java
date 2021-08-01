package t7_LinkedList;

public class _35_copyRandomList {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // 先创建影子队伍
        Node pit1 = head;
     
        while(pit1 != null) {
        	Node pit2 = new Node(pit1.val);
			pit2.next = pit1.next;
			pit1.next = pit2;
			
			pit1 = pit1.next.next;

        }
        
        // 组建好影子队伍的random指针
        pit1 = head;
        while(pit1 != null) {
        	if(pit1.random != null) { // 凡是带有next的都要检查一下
        		pit1.next.random = pit1.random.next;
        	}
        	pit1 = pit1.next.next;
        }
        
        // 脱离原队伍，自己带队
        pit1 = head;
        Node pit2 = head.next;
        Node resHead = pit2;
        
        while(pit1 != null) { 
        	pit1.next = pit2.next;
        	pit1 = pit1.next;
        	if(pit2.next != null) {
        		pit2.next = pit2.next.next;
        		pit2 = pit2.next;
        	}
        }
        
        return resHead;
    }
}
