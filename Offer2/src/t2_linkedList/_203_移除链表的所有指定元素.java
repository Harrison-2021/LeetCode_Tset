package t2_linkedList;

public class _203_�Ƴ����������ָ��Ԫ�� {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {}
		
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while(pre.next != null) {
            if(pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
