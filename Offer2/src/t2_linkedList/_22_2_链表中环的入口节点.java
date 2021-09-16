package t2_linkedList;

import java.util.HashSet;
import java.util.Set;

public class _22_2_�����л�����ڽڵ� {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	// ��������Ƕ������������β��һ��ָ��ͷ��������ͷ������ͻ�������Σ������ù�ϣ�������������ظ�����
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {
			if(set.contains(head)) {
				return head;
			} else {
				set.add(head);
			}
			head = head.next;
		}
		
		return null;
	}
	
	// ˫ָ�뷨
	// �ҵ���һ��������
	// fast��������slow��һ������slow����ǰ��ʱ��ÿ��һ�Σ�����1�����ղ���Ϊ0������
	// ��Ҫ�ų�û�л���������ǵ�һ�ξͲ���������fast��һֱ�ߵ���β
	// ����ͷ������ڴ��ڵ���Ϊa�����нڵ���Ϊb��fast����f��slow����s����f=s+nb,f=2s==>s=nb
	// ��ͷ������ڣ�a+nb,s=nb,�ʣ�slow����a���ɵ��ﻷ���
	// Ϊ��ͳ��a������˫ָ�룬��ͷ����slowͬʱ������ͷ���������Ϊa�����ٴ�����ʱ�����߶�����a
	// s = m + (n -1)*(m + d),��ͷ�ڵ㣬��������ͷ�ƽ���һ������Ŀ��ڵ���
	public ListNode detectCycle2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) { // ��Ϊfastһ�ε���������fast.next.next,Ҫ���ж�fast.next!=null
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) break;
		}
		
		if(fast == null || fast.next == null) {
			return null;
		}
		
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
	
}
