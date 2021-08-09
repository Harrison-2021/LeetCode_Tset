package t9_BSTTree;

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
}
