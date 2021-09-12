package t1_Array;

import java.util.HashSet;
import java.util.Set;

public class _03_findRepeatNumber {
//	���漰���ظ�Ԫ��ʱ�������뵽��ϣ����򵥣��ٴΣ��뵽����
//	1.ʹ�ù�ϣ��
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

//	2. ���򣬲���ֱ�����򣬶��ǽ�������ֵ��Ӧ����һ�Զ࣬
//		�Ƚ�һ��ֵ�ŵ���Ӧ�����ϣ��´��ٴ�������ֵ���ͻ��ظ���Ӧ���������ҵ��ظ���ֵ
	public int findRepeatNumber2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (i != nums[i]) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				} else {
					swap(nums, i, nums[i]); // ��ֵ��Ӧ�ŵ���Ӧ�������ϣ��´���������ͬ��ֵ���������ظ���
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
