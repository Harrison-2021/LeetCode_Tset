package t9_BSTTree;

/**
 * @author ls2690069470 Offer 07. 重建二叉树
 */
public class _7_buildTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length) return null;
		
		int length = preorder.length;
		return buildTree(preorder, 0, length - 1, inorder, 0, length - 1);
	}
	
	private TreeNode buildTree(int[] pre, int startPre, int endPre, int[]in, int startIn, int endIn) {
		int rootValue = pre[startPre];
		TreeNode root = new TreeNode(rootValue);
		root.left = root.right = null;
		
		if(startPre == endPre) {
			if(startIn == endIn) {
				return root;
			} else {
				throw new IllegalArgumentException("invalid input!");
			}
		}
		
		// find the location of root in in_order 
		int rootIn = startIn;
		while(rootIn <= endIn && in[rootIn] != rootValue) {
			rootIn ++;
		}
		
		if(rootIn == endIn && in[rootIn] != rootValue) {
			throw new IllegalArgumentException("invalid input!");
		}
		
		// build leftChild
		int leftLength = rootIn - startIn;
		int leftPreEnd = startPre + leftLength; // 一定要定义好左子树的长度，每递归一次，长度不同，偏移也不同
		
		if(rootIn > startIn) {
			root.left = buildTree(pre, startPre + 1, leftPreEnd, in, startIn, rootIn - 1);
		}
		
		// build rightChild
		if(rootIn < endIn) {
			root.right = buildTree(pre, leftPreEnd + 1, endPre, in, rootIn + 1, endIn);
		}
		
		return root;
	}
}
