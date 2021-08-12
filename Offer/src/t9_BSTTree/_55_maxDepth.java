package t9_BSTTree;

import java.util.*;

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
	// DFS 后续遍历
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;			
		}
		
//		int leftDepth = maxDepth(root.left);
//		int rightDepth = maxDepth(root.right);
//		
//		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	// BFS 层序遍历
	public int maxDepth2(TreeNode root) {
		if(root == null) return 0;
		
		@SuppressWarnings("serial")
		List<TreeNode> queue = new LinkedList<TreeNode>() {
			{ add(root); }
		}, temp;
		/* List<TreeNode> temp; */
		
		int res = 0;
		
		while(!queue.isEmpty()) {
			temp = new LinkedList<TreeNode>();
			
			for(TreeNode node: queue) {
				if(node.left != null) temp.add(node.left);
				if(node.right != null) temp.add(node.right);
			}
			
			queue = temp;
			res ++;
		}
		
		return res;
	}
}
