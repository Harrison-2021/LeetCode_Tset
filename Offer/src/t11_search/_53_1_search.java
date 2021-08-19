package t11_search;


/**
 * @author ls2690069470
 *	Offer 53 - I. 在排序数组中查找数字 I
 */
public class _53_1_search {
	 public int search(int[] nums, int target) {
		 if(nums.length == 0) return 0;
		 
		 int first = getFirstK(nums, target, 0, nums.length - 1);
		 int last = getLastK(nums, target, 0, nums.length - 1);
		 
		 return (first > -1 && last > -1) ? last - first + 1 : 0;
	 }

	private int getFirstK(int[] nums, int k, int l, int r) {
		if(l > r) return -1; //不能return 0, 因为0可能是正解
		
		int mid = l + (r - l) / 2;
		
		if(nums[mid] == k) {
			if((mid > 0 && nums[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				r = mid - 1;
			}
		}		
		else if(nums[mid] > k) {
			r = mid - 1;
		} else {
			l = mid + 1;
		}
		return getFirstK(nums, k, l, r);
	}

	private int getLastK(int[] nums, int k, int l, int r) {
		if(l > r) return -1; // 不能return 0, 因为0可能是正解
		
		int mid = l + (r - l) / 2;
		
		if(nums[mid] == k) {
			if((mid < nums.length - 1 && nums[mid + 1] != k) || mid == nums.length - 1) {
				return mid;
			} else{
				l = mid + 1;
			}
		} else if(nums[mid] > k) {
			r = mid - 1;
		} else {
			l = mid + 1;
		}
		return getLastK(nums, k, l, r);
	}
}
