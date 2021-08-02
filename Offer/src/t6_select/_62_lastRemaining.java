package t6_select;


/**
 * @author ls2690069470
 *     圆圈中最后剩下的数字
 */
public class _62_lastRemaining {
	// 递归法，使用O(n)的栈空间
	public int lastRemaining(int n, int m) {
		 return f(n, m);
	}

	private int f(int n, int m) {
		if(n == 1) {
			return 0;
		}
		
		int index = f(n -1, m);
		return (m + index) % n;
	}
	
	// 迭代法 O(1)空间
	public int lastRemaining2(int n, int m) {
		int f = 0;
		for(int i = 2; i < n + 1; i ++) { // 循环终止条件从前几个数中找规律
			f = (m + f) % i;
		}
		return f;
	}
}
