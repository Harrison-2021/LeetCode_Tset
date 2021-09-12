package t1_Array;

import java.util.HashSet;
import java.util.Set;

public class _03_findRepeatNumber {
//	当涉及到重复元素时，首先想到哈希表，最简单，再次，想到排序
//	1.使用哈希表
	public int findRepeatNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return nums[i];
			} else {
				set.add(nums[i]);
			}
		}
		return -1;
	}

//	2. 排序，不是直接排序，而是将索引与值对应，是一对多，
//		先将一个值放到对应索引上，下次再次遇到改值，就会重复对应到索引，找到重复的值
	public int findRepeatNumber2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (i != nums[i]) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				} else {
					swap(nums, i, nums[i]); // 将值对应放到对应的索引上，下次再遇到相同的值，索引就重复了
				}
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
