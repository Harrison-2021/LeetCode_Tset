package t9_BSTTree;

/**
 * @author ls2690069470
 *	Offer 55 - II. 平衡二叉树
 */
public class _55_2_isBalanced {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 public boolean isBalanced(TreeNode root) {
		 return recur(root) != -1; // 因为recur需要返回数的深度，无法同时返回正确与否，
		 					 // 因此需要一个数来辅助判断正确性
	 }

	 // 只需要从底到顶判断一次，如果是-1就不再递归调用，一直往上传递不是平衡树的讯息即可
	private int recur(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int left = recur(node.left); // 记录下下个节点的深度，java不能放在函数形参中，没有引用和指针变量
									 // 只能定义引用变量指向返回的结果
		if(left == -1) return -1;
		int right = recur(node.right);
		if(right == -1) return -1;
		
		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
		
	}	
}
