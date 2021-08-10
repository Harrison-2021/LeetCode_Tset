package t9_BSTTree;

import java.util.*;

/**
 * @author ls2690069470 Offer 32 - II. 从上到下打印二叉树 II 每一层打印到一行。
 */
public class _32_2levelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
//		if(root == null) {  与题意不合，root 为空时，输出[ ] ,反之求解
//			return null;
//		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
		}
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int nextLever = 0; // next lever's number
		int curNum = 1;    // cur lever's number
		
		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			
			for(int i = 0; i < curNum; i ++) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.add(node.left);
					nextLever ++;
				}
				if(node.right != null) {
					queue.add(node.right);
					nextLever ++;
				}
				temp.add(node.val);
			}
			
			res.add(temp);
			
			curNum = nextLever;
			nextLever = 0;
		}
		
		return res;
	}
}
