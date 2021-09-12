package t3_Array;

import java.util.*;

/**
 * @author ls2690069470 Offer 39. 数组中出现次数超过一半的数字,请找出这个数字
 *         本题设定是一定存在一个数的次数比数组一半多，目标是找到这个数
 */
public class _39_majorityElement {
	// 开额外空间O(n)
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int k : nums) {
			if (map.containsKey(k)) {
				map.put(k, map.get(k) + 1);
			} else {
				map.put(k, 1);
			}
			if (map.get(k) > nums.length / 2) {
				return k;
			}
		}
		return 0;
	}

	// 直接找到最大的哈希键值，减少时间
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> counts = countNums(nums);

		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}

		return majorityEntry.getKey();
	}

	private Map<Integer, Integer> countNums(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!counts.containsKey(num)) {
				counts.put(num, 1);
			} else {
				counts.put(num, counts.get(num) + 1);
			}
		}
		return counts;
	}

	// 不额外开O(n)空间，只有O(1),摩尔投票法
	public int majorityElement3(int[] nums) {
		// 每两个数进行比较，不同就相消，形同留下，数组就用最后一个索引下标来维护数组元素大小
		int mode = 0, votes = 0;
		for (int k : nums) {
			if (votes == 0) {
				mode = k; // 假定第一个是众数，只要抵消为零时，消除的所有元素一定是小于等于一半的众数，最后剩下的一定是众数
			}
			votes += (k == mode) ? 1 : -1;
		}

		return mode;

	}

	// 先排序，此时的中位数一定是那个出现次数大于数组一半的数
	public int majorityElement4(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length >> 1];
	}
}
