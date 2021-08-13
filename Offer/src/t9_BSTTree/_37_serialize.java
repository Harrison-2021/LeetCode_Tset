package t9_BSTTree;

import java.util.LinkedList;
import java.util.Queue;

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

	// 方法一：后续遍历
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
		
	// 方法二： 层序遍历, 至顶向下，无需递归
	private String NULL = "$";
	private String SPLIT = ",";
	public String serialize2(TreeNode root) {
		if(root == null) {
			return "[]";
		}
		
		StringBuilder res = new StringBuilder("[");
		@SuppressWarnings("serial")
		Queue<TreeNode> queue = new LinkedList<TreeNode>() {
			{ add(root); }
		};
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node != null) {
				res.append(node.val + SPLIT);
				queue.add(node.left);
				queue.add(node.right);
			} else {
				res.append(NULL + SPLIT);
			}
		}
		
		res.deleteCharAt(res.length() - 1); // 注意格式
		res.append("]");
		return res.toString();
	}
	
	public TreeNode deserialize2(String data) {
		if(data == "[]") return null;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		String[] vals = data.substring(1, data.length() - 1).split(SPLIT);// 去掉括号，endIndex不包括
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		queue.add(root);
		
		int i = 0; // 变量位置要放好
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll(); // 此 node 已经new出来了，默认left = right = null
			
//			node.left = new TreeNode(Integer.parseInt(vals[++i])); // 这样处理会传入空指针
			if(!vals[++i].equals(NULL)) {
				node.left = new TreeNode(Integer.parseInt(vals[i]));
				queue.add(node.left);// 重建二叉树，对列里只储存非空父节点，方便下次拿出调用
			} 
			/* else node.left = null; */
			if(!vals[++i].equals(NULL)) { // 一定要用equals判断是否相等
				node.right = new TreeNode(Integer.parseInt(vals[i]));
				queue.add(node.right);
			}
			/* else node.right = null; */
		}
		
		return root;
	}
}
