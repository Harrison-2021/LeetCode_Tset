package t9_BSTTree;

import java.util.*;

/**
 * @author ls2690069470 Offer 34. 二叉树中和为某一值的路径
 */
public class _34_pathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		LinkedList<Integer> path = new LinkedList<Integer>();
//		int curSum = 0;
//		if(root != null) {
			pathSum(root, target, path/* , curSum */);
//		}
		return res;
	}

	private void pathSum(TreeNode root, int target, LinkedList<Integer> path/* , int curSum */) {
		if(root == null) return; // 因此在主函数中，也无需对root进行判断
//		curSum += root.val;
		target -= root.val;
		path.addLast(root.val);

		// 实际上相当于先序遍历，先拿到遍历的根节点，放入path中，再遍历左右子树
		boolean isLeaf = (root.left == null && root.right == null);
		
		if(/*curSum == target*/ target == 0 && isLeaf == true) {
//			res.add(path); // 注意，若直接将path对象加入，只有一个path,后续path改变，res中的path也会改变
			res.add(new LinkedList<Integer>(path));
		}
		
//		if(root.left != null) { 可以不用每次判断，最后一次子树为空时，在自述调用中处理即可
			pathSum(root.left, target, path/* , curSum */);
//		}
//		if(root.right != null) {
			pathSum(root.right, target, path/* , curSum */);
//		}
		
		// 在返回父亲节点前，如果该路径正确，已经加入了res中，要找下个路径，将当前叶子节点删除，添加下个叶子节点
		// 递归调用，会自动返回父亲节点，注意，删除的是最后进入的，相当与栈的操作
//		path.removeLast(); 不需要用curSum -= path.removeLast(),返回父节点时，此curSum自然也消失了
		path.removeLast();
	}		
}
