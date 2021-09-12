package t1_Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 两种思路，一是用哈希表，只要涉及到次数统计的都可以用哈希表，
// 			二是排序，中位数一定是重复次数超过一半的数，
//					因为这个数不管是放在中位数左边还是右边都是要超出边界的，故，中位数的位置一定包含在这个数的长度内
public class _39_majorityElement {
//	方法一、哈希表
	public int majorityElement(int[] nums) {
		if (nums.length == 0)
			return -1;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
//			if (map.get(nums[i]) > nums.length / 2) {
//				return nums[i];
//			}
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > nums.length >> 1) {
				return e.getKey();
			}
		}

		return -1;
	}

//	方法二、排序法， 使用O(n log(n)) 的快速排序法
	public int majorityElement2(int[] nums) {
		if (nums.length == 0)
			return -1;
		quickSort(nums);
		return nums[nums.length >> 1];
	}

	private void quickSort(int[] nums) {
		Random rad = new Random();
		quickSort(nums, 0, nums.length - 1, rad); // 传入的区间是闭区间

	}

	private void quickSort(int[] nums, int l, int r, Random rad) {
		if(l >= r) return;
		
		int p = partition(nums, l, r, rad);
		quickSort(nums, l, p - 1, rad);
		quickSort(nums, p + 1, r, rad);
	}

	private int partition(int[] nums, int l, int r, Random rad) {
		int index = l + rad.nextInt(r - l + 1);
		swap(nums, l, index);
		
		int i = l + 1, j = r;
		while(true) {
			while(i <= j && nums[i] < nums[l]) { // 注意是while循环
				i ++;
			}
			while(i <= j && nums[j] > nums[l]) {
				j --;
			}
			
			if(i >= j) break;
			
			if(nums[i] != nums[j]) {
				swap(nums, i, j);
			}
			
			i ++;
			j --;
		}
		
		swap(nums, l, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
		
	}

//	方法三、不额外开O(n)空间，只有O(1),摩尔投票法
	public int majorityElement3(int[] nums) {
		if(nums.length == 0) return -1;
		// 本题默认一定存在比数组一半元素多的元素，那么这个元素只要拿出剩下少于一半数组数目的元素去抵消异类，最后就一定会留下这个元素的类型
		int mode = 0, votes = 0;
		for(int k : nums) {
			if(votes == 0) {
				mode = k; // 先设定第一个元素为擂主，同类，就一开站，异类，就同归于尽一个，最后留下的就是最多数的一个
			}
			votes += (mode == k ? 1 : -1);
		}
		return mode;
	}
}
