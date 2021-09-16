package t7_LinkedList;

public class _36_treeToDoublyList {
	// Definition for a Node.
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
	};

	// 确定需要的指针，返回的头节点 head, 当前节点curPit(局部变量), 前一个节点prePit
	private Node prePit = null, head = null;
	
    public Node treeToDoublyList(Node root) {
        // 特殊情况先排除
    	if(root == null) return null;
    	
    	// 递归中序遍历，查找到链表中的每个元素，将链表left，right指向定义好
    	inOrder(root);
    	
    	// 为了构建循环列表，将首尾相连
    	// prePit每次都是维护curPit的值，遍历完后，curPit指向最后一个最大元素，即prePit指向链尾   	
    	head.left = prePit;
    	prePit.right = head;
    	
    	return head;
    }
    
    private void inOrder(Node curPit) {
    	if(curPit == null) return;
    	
    	inOrder(curPit.left);
    	
    	// 将当前找到的node与前一个节点构建成双向链表
    	// 要维护链表头元素，当prePit为null，即当前节点为头节点，要用一个指针指着，先定义好右索引就行
    	if(prePit == null) {
    		head = curPit;
    	} else {
    		prePit.right = curPit;
    	}
    	curPit.left = prePit;
    	
    	// 维护prePid，以便与下个节点构成链表
    	prePit = curPit;
    	
    	inOrder(curPit.right);
    }
}