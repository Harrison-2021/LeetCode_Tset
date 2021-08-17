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
	
	// 方法二： 考虑大数据越界情况，转化为字符数方式
	int count = 0;
	int nine = 0;
	int n, start;
	int[] res;
	char[] nums, loop = {'0','1','2','3','4','5','6','7','8','9'};
	public int[] printNumbers2(int n) {
		this.n = n;
		res = new int[(int)Math.pow(10, n) - 1];
		nums = new char[n];
		start = n - 1;
		dfs(0);
		return res;
	}
	private void dfs(int i) {
		if(i == n) {
			/* String s = nums.toString().substring(start);  不能用默认的toString，转换的字符串不是自己需要的字符串*/
			String s = String.valueOf(nums).substring(start);
			if(!s.equals("0")) res[count ++] = Integer.parseInt(s);
			if(start + nine == n) start --; // 9，99，999进位
			return; // 递归终止，不要忘记return
		}
		
		for(char k : loop) {
			if(k == '9') nine ++; // nine 会影响start，所以要先判断
			nums[i] = k;
			dfs(i + 1);
		}
		
		nine --; // 一定要维护nine，只有当9，99，999...时候才进位，其他情况start不变
	}
}
