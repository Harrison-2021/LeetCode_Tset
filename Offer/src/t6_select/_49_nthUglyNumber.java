package t6_select;


/**
 * @author ls2690069470
 *	Offer 49. 丑数
 */
public class _49_nthUglyNumber {
	public int nthUglyNumber(int n) {
		if(n <= 0) return -1;
		
		int[] pUgly = new int[n]; 	// 储存已有丑数的数组
		pUgly[0] = 1;			  	// 初始丑数为1
		int nextUglyIndex = 1;		// 按顺序下一个未知丑数在数组中的索引
		int p2 = 0, p3 = 0, p5 = 0;	// 2，3，5丑数因子的下标索引，与已知丑数相乘一定还是丑数
		
		while(nextUglyIndex < n) {
			pUgly[nextUglyIndex] = min(pUgly[p2]*2, pUgly[p3]*3, pUgly[p5]*5);
			// 更新丑数临界点，并记住临界点
			while(pUgly[p2] * 2 <= pUgly[nextUglyIndex]) {
				p2 ++; // 找下一个大于已知丑数的，可能的最小丑数
			}
			while(pUgly[p3] * 3 <= pUgly[nextUglyIndex]) {
				p3 ++;
			}
			while(pUgly[p5] * 5 <= pUgly[nextUglyIndex]) {
				p5 ++;
			}
			
			nextUglyIndex ++;			
		}
		
		return pUgly[nextUglyIndex -1];
	}

	private int min(int i, int j, int k) {
		int min = i < j ? i : j;
		return min < k ? min : k;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new _49_nthUglyNumber().nthUglyNumber(10));

	}
}
