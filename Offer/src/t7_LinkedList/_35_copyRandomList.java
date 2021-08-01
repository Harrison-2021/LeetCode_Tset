package t7_LinkedList;

import java.util.*;

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
        
        while(pit2.next != null) { // 防止代码错误，可以在终止条件上就避免空指针错误
        	pit1.next = pit1.next.next;
        	pit2.next = pit2.next.next;
        	pit1 = pit1.next;
        	pit2 = pit2.next;
//        	if(pit2.next != null) {
//        		pit2.next = pit2.next.next;
//        		pit2 = pit2.next;
//        	}        	
        }
        pit1.next = null; // 维护旧链表的完整性
        
        return resHead;
    }
	
	// 哈希表法，映射，就是影子工程
	public Node copyRandomList2(Node head) {
		if(head == null) return null;
		
		Node cur = head;
		Map<Node, Node> map = new HashMap<>(); // 父类引用指向子类对象
		
		// 添加键值对，旧节点映射新节点
		while(cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		
		// 添加新链表节点的next。random，参考旧链表的对应的节点
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		
		return map.get(head);
	}
}
