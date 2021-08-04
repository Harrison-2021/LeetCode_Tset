package t3_Array;

import java.util.*;

/**
 * @author ls2690069470 Offer 39. 数组中出现次数超过一半的数字
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
			if (map.get(k) > nums.length) {
				return k;
			}
		}
		return 0;
	}

	// 直接找到最大的哈希键值，减少时间
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
	
	// 不额外开O(n)空间，只有O(1)
	public int majorityElement3(int[] nums) {
		// 没两个数进行比较，不同就相消，形同留下，数组就用最后一个索引下标来维护数组元素大小
		int lastCount = 0;
		int lastNum = 0;
		
		for(int k : nums) {
			if(lastCount == 0) {
				lastNum = k;
				lastCount = 1;
			} else {
				if(lastNum == k) {
					lastCount ++;
				} else {
					lastCount --;
				}
			}
		}
		
		if(lastCount == 0) {
			return 0;
		} else {
			return lastNum; //本题设定是找到最多的元素，就是比数组一半长度多
		}
		
	}
}
