package t3_Array;

/**
 * @author ls2690069470 Offer 42. 连续子数组的最大和
 */
public class _42_maxSubArray {
	// 变量记录法，根据累加数据找规律，找到和为负数的临界点，以及记录历史最大值
	public int maxSubArray(int[] nums) {
		int curSum = 0;
		int resSum = Integer.MIN_VALUE;

		for (int k : nums) {
			if (curSum <= 0) {
				curSum = k;
			} else {
				curSum += k;
			}

			if (curSum > resSum) {
				resSum = curSum;
			}
		}

		return resSum;
	}

	// 实质是动态规划，可以简化代码
	public int maxSubArray2(int[] nums) {
//		int res = nums[0];
//		for(int i = 1; i < nums.length; i ++) {
//			nums[i] += Math.max(nums[i - 1], 0);
//			res = Math.max(nums[i], res);
//		}
//		return res;
		
		int curSum = 0, res = nums[0];
		for(int k : nums) {
			curSum = Math.max(curSum + k, k);
			res = Math.max(curSum, res);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toHexString(Integer.MIN_VALUE));
	}
}
