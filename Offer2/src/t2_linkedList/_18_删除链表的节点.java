package t2_linkedList;

public class _18_ɾ������Ľڵ� {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {}
		
		ListNode(int x) {
			val = x;
		}
	}
	// �����������ָ�룬�����õ����ҵ�Ҫɾ���Ľڵ㣬�ٴ���ָ��ָ�򼴿ɣ�Ϊ�˴���ͷ�ڵ㣬������ͷ�ڵ�
	public ListNode deleteNode(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0); // ͷ�ڵ�ֻ����Ҫ�õ�ָ��������ֵ���ã�������㸳ֵ
		dummyHead.next = head;
		ListNode pre = dummyHead;
		
		while(pre.next != null) {
			if(pre.next.val == val) {
				pre.next = pre.next.next;
				return dummyHead.next; // dummyHead�Ѿ��ı��ˣ�Ҫ��д����һ����������ֹ��Ⱦ
			} else {
				pre = pre.next;
			}
		}
		
		return null;
	}
}

