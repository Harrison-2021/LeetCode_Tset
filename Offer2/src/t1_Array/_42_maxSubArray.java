package t1_Array;

public class _42_maxSubArray {
	public int maxSubArray(int[] nums) {
		int curSum = 0;
		int resSum = Integer.MIN_VALUE;
		
		for(int k : nums) {
			if(curSum <= 0) {
				curSum = k;
			} else {
				curSum += k;
			}
			
			if(curSum > resSum) {
				resSum = curSum;
			}
		}
		return resSum;
	}
	
	// ��̬�滮��ʵ�����ҵ�dp[i] �� dp[i - 1]�Ĺ�ϵ
	public int maxSubArray2(int[] nums) {
		int res = nums[0];
		for(int i = 1; i < nums.length; i ++) {
			nums[i] += Math.max(nums[i - 1], 0);
			res = Math.max(res, nums[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
	}
}
