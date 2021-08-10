package t9_BSTTree;

import java.util.*;


/**
 * @author ls2690069470
 *	Offer 32 - III. 从上到下打印二叉树 III
 *	之字性打印二叉树
 */
public class _32_3_levelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
		}
		
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		
		while(!queue.isEmpty()) {
			LinkedList<Integer> temp = new LinkedList<>();
			for(int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				
				if(res.size() % 2 == 0) {
					temp.addLast(node.val);
				} else {
					temp.addFirst(node.val);
				}
				
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(temp);
		}
		return res;
	}
}
