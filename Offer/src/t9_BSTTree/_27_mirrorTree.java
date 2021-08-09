package t9_BSTTree;

import java.util.Stack;

/**
 * @author ls2690069470 Offer 27. 二叉树的镜像
 * 	Offer 27. 二叉树的镜像
 */
public class _27_mirrorTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	 public TreeNode mirrorTree(TreeNode root) {
		 if(root == null) return null;
		 
		 if(root.left == null && root.right == null) {
			 return root;
		 }
		 
		 TreeNode temp = root.left;
		 root.left = root.right;
		 root.right = temp;
		 
		 if(root.left != null) {
			 root.left = mirrorTree(root.left);
		 }
		 if(root.right != null) {
			 root.right = mirrorTree(root.right);
		 }
		 
		 return root;
	 }
	 
	 public TreeNode mirrorTree2(TreeNode root) {
		 if(root == null) return null;
		 
		 TreeNode temp = root.left;
		 root.left = mirrorTree(root.right);
		 root.right = mirrorTree(temp);
		 
		 return root;
	 }
	 
	 public TreeNode mirrorTree3(TreeNode root) {
	        if(root == null) return null;
			Stack<TreeNode> stack = new Stack<TreeNode>();/*
															 * { { add(root); }};
															 */
			stack.add(root);
			
	        while(!stack.isEmpty()) {
	            TreeNode node = stack.pop();
	            if(node.left != null) stack.add(node.left);
	            if(node.right != null) stack.add(node.right);
	            TreeNode tmp = node.left;
	            node.left = node.right;
	            node.right = tmp;
	        }
	        return root;
	    }

}
