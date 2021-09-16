package t2_linkedList;

public class _24_��ת���� {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// ��ת�����ʵ�ʣ��Ǹı������ָ�򣬿���ԭ�ر�������������������
	public ListNode reverseList(ListNode head) {
		ListNode left = null;
		ListNode mid = head;
		
		while(mid != null) {
			ListNode right = mid.next;
			mid.next = left;
			
			left = mid;
			mid = right;
		}
		
		return left;
	}
	
	// �ݹ鷨
	// ΢������ֻ��head.next == null,head==null�Ǳ߽�����
	// �ݹ�����ҵ����һ���ڵ㣬����Ϊ�µ�ͷ�ڵ㣬Ҳ�ǵݹ���ֹ������
	// ������壬������Ҫ����head.next �� head �Ĺ�ϵ�������߼�
	// һֱ���µĽڵ����ϴ��ݣ�ֱ�����нڵ�ָ�򶼸ı��꣬�ص������������µ�����ͷ�ڵ�
	public ListNode reverseList2(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode newHead = reverseList2(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}
