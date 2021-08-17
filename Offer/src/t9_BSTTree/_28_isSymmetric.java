package t9_BSTTree;

/**
 * @author ls2690069470 Offer 28. 对称的二叉树
 */
public class _28_isSymmetric {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return recur(root.left, root.right);
	}

	private boolean recur(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null || left.val != right.val) return false;
		
		return recur(left.left, right.right) && recur(left.right, right.left);
	}
}
