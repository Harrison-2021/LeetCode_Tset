package t10_dynamic_p;

/**
 * @author ls2690069470 Offer 17. 打印从1到最大的n位数
 */
public class _17_printNumbers {
	// 方法一：直接打印，本题中默认返回int数组，不存在大数据越界问题
	public int[] printNumbers(int n) {
		int end = (int)Math.pow(10, n) - 1;
		int[] res = new int[end];
		
		for(int i = 0; i < end; i ++) {
			res[i] = i;
		}
		
		return res;
	}
}
