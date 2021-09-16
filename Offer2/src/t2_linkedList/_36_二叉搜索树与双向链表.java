package t2_linkedList;

public class _36_二叉搜索树与双向链表 {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	}

	Node prePit = null, head = null;
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		
		inOrder(root);
		
		head.left = prePit;
		prePit.right = head;
		
		return head;
	}
	private void inOrder(Node curNode) {
		if(curNode == null) return;
	
		inOrder(curNode.left);
		
		if(prePit == null) {
			head = curNode;
		} else {
			prePit.right = curNode;
		}
		curNode.left = prePit;
		
		prePit = curNode;
		
		inOrder(curNode.right);
		
	}
}
