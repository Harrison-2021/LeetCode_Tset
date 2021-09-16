package t2_linkedList;

import java.util.LinkedList;

public class _06_��β��ͷ��ӡ���� {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// �����ӡ�������ø���ջ�Ľ������ı�˳��
	public int[] reversePrint(ListNode head) {
		ListNode cur = head;
		LinkedList<ListNode> linked = new LinkedList<>();
		
		while(cur != null) {
			linked.addFirst(cur);
			cur = cur.next;
		}
		
		int[] res = new int[linked.size()];
		for(int i = 0; i < res.length; i ++) {
			res[i] = linked.remove().val;
		}
		
		return res;
	}
	
	// ʹ�õݹ鷨,�ݹ��ʵ��Ҳ��ջ�����ȵݹ鵽�ף�
	// ���ȴ���ݹ�����⣬�����ȴ���β�����ٴ���ͷ����ʵ�ֵ��� 
	LinkedList<ListNode> set = new LinkedList<>();
	public int[] reversePrint2(ListNode head) {
		recure(head);
		int[] res = new int[set.size()];
		for(int i = 0; i < res.length; i ++) {
			res[i] = set.remove().val;
		}
		return res;
	}
	private void recure(ListNode node) {
		if(node == null) return;
		
		recure(node.next);
		set.addLast(node);		
	}
}
