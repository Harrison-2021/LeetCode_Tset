package t6_select;

public class Offer21 {
	int[] arr;
	
	// 空间O(n),另辟空间
	public int[] exchange(int[] nums) {
		arr = new int[nums.length];
		int i = 0;
		for(int k : nums) {
			if(k % 2 == 1) {
				arr[i++] = k;
			}
		}
		
		for(int k : nums) {
			if(k % 2 == 0) {
				arr[i++] = k;
			}
		}
		return arr;
    }
	
	// 原地查找 首尾双指针
	public int[] exchange2(int[] nums) {
		int left = 0, right = nums.length -1;
		
		while(left < right) {
			if((nums[left] & 1) == 1) {
				left ++;
				continue;
			} 
			if((nums[right] & 1) == 0) {
				right --;
				continue;
			}
			swap(nums, left, right);
		}
		
		return nums;
    }
	
	//原地查找 快慢双指针
	public int[] exchange3(int[] nums) {
		int fast = 0, low = 0;
		
		while(fast < nums.length) {
			if((nums[fast] & 1) == 1) {
				swap(nums, fast, low);
				low ++;
			}
			fast ++;
		}
		return nums;
	}
	private void swap(int[] nums, int left, int right) {
		int t = nums[left];
		nums[left] = nums[right];
		nums[right] = t;
	}
		
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] arr = new Offer21().exchange3(nums);
		for(int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i]);
		}
		
	}	
}
