package t2_linkedList;

import java.util.LinkedList;

/**
 * @author ls2690069470
 *     ��ĿҪ���Ƿ����Ե���k�ڵ�Ϊͷ�ڵ������
 */
public class _22_�����е�����k���ڵ� {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	// ����һ���ø���ջ�������нڵ㣬�������������
	public ListNode getKthFromEnd(ListNode head, int k) {
		LinkedList<ListNode> linked = new LinkedList<>();
		ListNode cur = head;
		
		while(cur != null) {
			linked.push(cur);
			cur = cur.next;
		}
		
		//cur = linked.peekFirst();  ��ʱͷ�ڵ��ָ��ָ��null�������ô˽ڵ�ȥ����
		cur = linked.get(k - 1); // �����������Դ��ķ�����ȡ�ض�λ�õ�Ԫ��
		return cur;
	}
	
	// ������������˫ָ�뷨��һ��һ����������k�����룬��ͬ���ƽ���ǰ����ߵ��ף���������þ���Ҫ��Ľڵ�
	public ListNode getKthFromEnd2(ListNode head, int k) {
		ListNode front = head;
		ListNode back = head;
		
		for(int i = 0; i < k; i ++) {
			front = front.next; // �����и�����������Խ�磬�����ж�
		}
		
		while(front != null) {
			front = front.next;
			back = back.next;
		}
		
		return back;
	}
}
