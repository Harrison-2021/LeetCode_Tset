package t7_LinkedList;

public class _24_reverseList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode left = null;
		ListNode mid = head;
				
		while(mid != null) { // 边界判断的核心是head即mid是否为空，可以整合
			ListNode right = mid.next; // mid不为空，有next时，保存next节点
			
			mid.next = left; // 核心代码，改变指向
			
			left = mid; // 维护两个确定的实指针
			mid = right;
		}
		
		return left;
    }
	
	// 递归法
	public ListNode reverseList2(ListNode head) {
		if(head == null || head.next == null) {// 微观语义只是head.next == null,head==null是边界条件
			return head;
		}
		
		ListNode newHead = reverseList2(head.next); // 宏观语义，head.next已经排好序，并且返回了hean.next
													// 接下来要处理head.next 与 head 的关系
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}
