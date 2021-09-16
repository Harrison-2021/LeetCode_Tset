package t2_linkedList;

import java.util.HashMap;
import java.util.Map;

public class _35_复杂链表的复制 {
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
	
	// 哈希表法，映射，就是影子工程
	// 添加键值对，旧节点映射新节点
	// 添加新链表节点的next。random，参考旧链表的对应的节点
	public Node copyRandomList(Node head) {
		if(head == null) return null;
		
		Node cur = head;
		Map<Node, Node> map = new HashMap<>();
		
		while(cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		
		return map.get(head);
	}
}
