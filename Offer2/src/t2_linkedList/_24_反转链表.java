package t2_linkedList;

public class _24_反转链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// 反转链表的实质，是改变链表的指向，可以原地遍历处理，无需另开辟区间
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
	
	// 递归法
	// 微观语义只是head.next == null,head==null是边界条件
	// 递归深处，找到最后一个节点，设置为新的头节点，也是递归终止的条件
	// 宏观语义，接下来要处理head.next 与 head 的关系，核心逻辑
	// 一直将新的节点往上传递，直到所有节点指向都改变完，回到顶部，传回新的链表头节点
	public ListNode reverseList2(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode newHead = reverseList2(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}
