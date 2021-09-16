package t2_linkedList;

import java.util.HashMap;
import java.util.Map;

public class _35_��������ĸ��� {
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
	
	// ��ϣ����ӳ�䣬����Ӱ�ӹ���
	// ��Ӽ�ֵ�ԣ��ɽڵ�ӳ���½ڵ�
	// ���������ڵ��next��random���ο�������Ķ�Ӧ�Ľڵ�
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
