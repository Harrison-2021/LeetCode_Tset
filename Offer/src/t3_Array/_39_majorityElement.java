package t3_Array;

import java.util.*;

/**
 * @author ls2690069470
 *	Offer 39. 数组中出现次数超过一半的数字
 */
public class _39_majorityElement {
	// 开额外空间O(n)
	 public int majorityElement(int[] nums) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int k : nums) {
			 if(map.containsKey(k)) {
				 map.put(k, map.get(k) + 1);
			 } else {
				 map.put(k, 1);
			 }
			 if(map.get(k) > nums.length) {
				 return k;
			 }
		 }
		 return 0;
	 }
}
