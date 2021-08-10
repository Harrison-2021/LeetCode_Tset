package t9_BSTTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ls2690069470 Offer 32 - I. 从上到下打印二叉树
 */
public class _32_levelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int[] levelOrder(TreeNode root) {
		if (root == null)
			return new int[0];

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root); /*
							 * 注意标准库中的是双头链表，有first，last定位指针， add与offer都是在末尾添加元素，O(1)复杂度
							 */
		ArrayList<TreeNode> array = new ArrayList<>();

		while (!queue.isEmpty()) { // 不能直接用null来判定一个容器是否位空
			TreeNode newNode = queue.poll();
			array.add(newNode);
			if (newNode.left != null) {
				queue.add(newNode.left);
			}
			if (newNode.right != null) {
				queue.add(newNode.right);
			}
		}
		
		int[] res = new int[array.size()];
		for(int i = 0; i < res.length; i ++) {
			res[i] = array.get(i).val;
		}
		return res;
	}

}
