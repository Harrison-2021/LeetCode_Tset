package t2_linkedList;

import java.util.HashSet;
import java.util.Set;

public class _52_��������ĵ�һ�������ڵ� {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// ����һ��ѭ���ǲ���
	// headA: a + c, headB: b + c => a+c+b = b+c+a,ÿ����������ô�ಽ��һ�������ߵ�һ���࣬�ཻ
	// �����������ཻ��ֻҪ����������a+c+b = b+c+a����һ��������ͬ�ڵ㣬����ָ��գ����ؿ�
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode pitA = headA;
		ListNode pitB = headB;
		
		while(pitA != pitB) {
			pitA = pitA != null ? pitA.next : headB;
			pitB = pitB != null ? pitB.next : headA;
		}
		
		return pitA;
	}
	
	// ��ϣ������������ײ�ѯ������
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
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
