package t9_BSTTree;

import java.util.LinkedList;

/**
 * @author ls2690069470 Offer 37. 序列化二叉树
 */
public class _37_serialize {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) return "[]";
		StringBuilder res = new StringBuilder();
		serialize(root, res);
		return res.toString();
	}

	private void serialize(TreeNode node, StringBuilder res) {
		if(node == null) {
			res.append("$,");
			return;
		}
		res.append(node.val + ",");
		serialize(node.left, res);
		serialize(node.right, res);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("[]")) return null;
		
		// 要有分割操作，拿到每个字符
		LinkedList<String> nodes = new LinkedList<String>();
		for(String s : data.split(",")) {
			nodes.add(s);
		}
		return recur(nodes);
	}

	private TreeNode recur(LinkedList<String> nodes) {
		if(nodes.isEmpty()) {
			return null;
		}
		
		String first = nodes.poll();
		if(first.equals("$")) return null;
		TreeNode root = new TreeNode(Integer.parseInt(first));
		
		root.left = recur(nodes);
		root.right = recur(nodes);
		
		return root;
	}
		
}
