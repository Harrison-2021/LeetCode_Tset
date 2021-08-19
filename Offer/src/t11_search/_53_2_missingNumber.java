package t11_search;

/**
 * @author ls2690069470 Offer 53 - II. 0～n-1中缺失的数字
 */
public class _53_2_missingNumber {
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return -1;
		}

		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = (l + r) >> 1;
			if(nums[mid] != mid) {
				if(mid == 0 || nums[mid - 1] == mid - 1) {
					return mid;
				} else {
					r = mid - 1;
				}
			} else {
				l = mid + 1;
			}
		}
		
		if(l == nums.length) { // 如果数组都满足，就是length位置不满足
			return l;
		}
		
		return -1;
	}
}
