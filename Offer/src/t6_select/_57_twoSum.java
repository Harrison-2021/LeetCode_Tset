package t6_select;

/**
 * @author ls2690069470
 *	Offer 57. 和为s的两个数字
 */
public class _57_twoSum {
	public int[] twoSum(int[] nums, int target) {
		if(nums.length < 0) return new int[0];
		
		int head = 0, tail = nums.length - 1; // 定义头，尾两个指针，从小到大
		
		while(head < tail) {
			long curSum = nums[head] + nums[tail];
			
			if(curSum == target) {
				return new int[] {nums[head], nums[tail]};
			} else if(curSum < target) {
				head ++;
			} else {
				tail --;
			}
		}
		
		return new int[0];
	}
}
