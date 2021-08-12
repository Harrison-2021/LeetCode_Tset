package t9_BSTTree;

/**
 * @author ls2690069470 Offer 55 - I. 二叉树的深度
 */
public class _55_maxDepth {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;			
		}
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}
}
