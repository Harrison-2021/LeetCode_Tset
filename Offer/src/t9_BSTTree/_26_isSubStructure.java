package t9_BSTTree;

/**
 * @author ls2690069470 Offer 26. 树的子结构
 */
public class _26_isSubStructure {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSubStructure(TreeNode A, TreeNode B) {
//		if(A == null || B == null) return false;
//		
//		// 注意，A，B本身就是两个树的根节点
//		// 找到A树中与B树相等的节点，以便进行下一步的逐个节点比较
//		boolean res = false;
//		if(A.val == B.val) {
//			res = recur(A, B);
//		} 
//		if(!res) {
//			res = isSubStructure(A.left, B);
//		}
//		if(!res) {
//			res = isSubStructure(A.right, B);
//		}
//		
//		return res;
		
		// 注意顺序
		return (A != null && B != null ) && 
				(recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	private boolean recur(TreeNode A, TreeNode B) {
		if(B == null) {
			return true;
		}
		if(A == null || A.val != B.val) {
			return false;
		}
				
		return recur(A.left, B.left) && recur(A.right, B.right);
	}
}
