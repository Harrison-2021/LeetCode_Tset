package t3_Array;


/**
 * @author ls2690069470
 *	Offer 03. 数组中重复的数字
 */
public class _03_findRepeatNumber {
	// 一维数组地址连续，可用下标顺序值对应相应元素，如果下标值与元素值不等，要么重复，要么没有排序好
	// 因此，先将前i个元素对应排序好，与元素对应的下标值交换，大的一定换到后面，小的换到前面
	public int findRepeatNumber(int[] nums) {
		for(int i = 0; i < nums.length; i ++) {
			while(i != nums[i]) {
				if(nums[i] == nums[nums[i]]) {
					return nums[i];
				} else {
					swap(nums, i, nums[i]);
				}
			}
		}
		
		return -1;
	}
	
	public int findRepeatNumber2(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			if(nums[i] == i) {
				i ++;
				continue;
			}
			if(nums[i] == nums[nums[i]]) {
				return nums[i];
			} else {
				swap(nums, i, nums[i]);
			}
		}
		return -1;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
		
	}
}
