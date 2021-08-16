package t10_dynamic_p;

/**
 * @author ls2690069470 Offer 14- I. 剪绳子
 */
public class _14_1_cuttingRope {
	public int cuttingRope(int n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;

		// 为计数方便，动态规划数组小标的值就是线段的长度值，需要有n个下标，因此需要n+1个空间
		int[] dp = new int[n + 1];
		/*
		 * 上面分析过长度小于等于3时存在的特殊情况， 
		 * 所以当绳子剪过之后，有一段长度小于等于3时，
		 * 就不应该继续剪，否则乘积就会变小，因此子数组维持其长度值，如果n<=3, 前面已经讨论过了
		 * 则在动态规划数组中，小于等于3的索引所指的元素应该等于其索引的值 代表剪过的绳子到这长度就不要继续剪了
		 */
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i = 4; i <= n; i ++) {
			for(int j = 1; j <= i / 2; j ++) {
				dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
			}
		}
		
		return dp[n];
	}
}
