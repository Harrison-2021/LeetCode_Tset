package t10_dynamic_p;


/**
 * @author ls2690069470
 *	Offer 14- II. 剪绳子,大数据需要取余操作
 */
public class _14_2_cuttingRope {
	public int cuttingRope(int n) {
		// 主要3的次方比较大，需要循环取余，2的次方只有1个或2个，直接取余就行
		if(n <= 3) return n -1;
		
		int timesOf3 = n / 3;
		
		if(n - 3 * timesOf3 == 1) {
			timesOf3 -= 1;
		}
		
		int timesOf2 = (n - timesOf3 * 3) / 2;
		
		int p = 1000000007;
		long rem = 1;
		
		// 循环取余公式，获得3^tiemsOf3 的取余结果
		for(int i = 0; i < timesOf3; i ++) {
			rem = (rem * 3) % p;
		}
		
		return (int)(rem * (int)Math.pow(2, timesOf2) % p); // 最终结果一定要再次取余，以防数越界
	}
}
