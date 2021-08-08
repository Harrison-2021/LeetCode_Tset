package t9_BSTTree;

import java.util.Stack;

/**
 * @author ls2690069470
 *	Offer 33. 二叉搜索树的后序遍历序列
 */
public class _33_verifyPostorder {
	 public boolean verifyPostorder(int[] postorder) {
		 if(postorder.length == 0) return true; // 对于数组，不要用null来判断，要用size来判断是否位空
		 int length = postorder.length;
		 return verifyPostorder(postorder, 0, length - 1);
	 }

	private boolean verifyPostorder(int[] postorder, int r, int l) {
		if(r >= l) return true;
		
		int root = postorder[l];
		// find left node
		int i = r;
		for(; i < l; i ++) {
			if(postorder[i] > root) {
				break;
			}
		}
		
		// find roght node
		int j = i;
		for(; j < l; j ++) {
			if(postorder[j] < root) {
				return false;
			}
		}
		
		// verify the leftChild
		boolean left = true;
		if(i > r) {
			left = verifyPostorder(postorder, r, i - 1);// 数组区间的维护要用变量，不能用0
		}
		
		// verify the rigthChild
		boolean rigth = true;
		if(i < l) {
			rigth = verifyPostorder(postorder, i, l - 1); // 注意不是l
		}
		return left && rigth;
	}
	
	// 辅助单调栈
	public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
            	root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

}
