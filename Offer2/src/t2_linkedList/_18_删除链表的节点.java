package t2_linkedList;

public class _18_删除链表的节点 {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {}
		
		ListNode(int x) {
			val = x;
		}
	}
	// 由于链表具有指针，可以用迭代找到要删除的节点，再处理指针指向即可，为了处理头节点，用虚拟头节点
	public ListNode deleteNode(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0); // 头节点只是需要用到指针索引，值不用，可以随便赋值
		dummyHead.next = head;
		ListNode pre = dummyHead;
		
		while(pre.next != null) {
			if(pre.next.val == val) {
				pre.next = pre.next.next;
				return dummyHead.next; // dummyHead已经改变了，要重写定义一个变量，防止污染
			} else {
				pre = pre.next;
			}
		}
		
		return null;
	}
}

