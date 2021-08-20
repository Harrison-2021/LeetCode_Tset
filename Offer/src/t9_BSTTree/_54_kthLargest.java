package t9_BSTTree;

/**
 * @author ls2690069470 Offer 54. 二叉搜索树的第k大节点
 */
public class _54_kthLargest {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	// 要将res，k 定义成全局变量，否则，局部变量只能传参，返回函数为void，返回时，改变得参数无法返回
	private int res = 0, k = 0;
	public int kthLargest(TreeNode root, int k) {
		if(root == null || k <= 0) return -1;
		dfs(root);	
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return; 
		
		dfs(root.right);
		
		if(--k == 0) {
			res = root.val;
			return;
		}
		
		dfs(root.left);
	}
}
