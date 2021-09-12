package t1_Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// ����˼·��һ���ù�ϣ��ֻҪ�漰������ͳ�ƵĶ������ù�ϣ��
// 			����������λ��һ�����ظ���������һ�������
//					��Ϊ����������Ƿ�����λ����߻����ұ߶���Ҫ�����߽�ģ��ʣ���λ����λ��һ��������������ĳ�����
public class _39_majorityElement {
//	����һ����ϣ��
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

//	�����������򷨣� ʹ��O(n log(n)) �Ŀ�������
	public int majorityElement2(int[] nums) {
		if (nums.length == 0)
			return -1;
		quickSort(nums);
		return nums[nums.length >> 1];
	}

	private void quickSort(int[] nums) {
		Random rad = new Random();
		quickSort(nums, 0, nums.length - 1, rad); // ����������Ǳ�����

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
			while(i <= j && nums[i] < nums[l]) { // ע����whileѭ��
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

//	�������������⿪O(n)�ռ䣬ֻ��O(1),Ħ��ͶƱ��
	public int majorityElement3(int[] nums) {
		if(nums.length == 0) return -1;
		// ����Ĭ��һ�����ڱ�����һ��Ԫ�ض��Ԫ�أ���ô���Ԫ��ֻҪ�ó�ʣ������һ��������Ŀ��Ԫ��ȥ�������࣬����һ�����������Ԫ�ص�����
		int mode = 0, votes = 0;
		for(int k : nums) {
			if(votes == 0) {
				mode = k; // ���趨��һ��Ԫ��Ϊ������ͬ�࣬��һ��վ�����࣬��ͬ���ھ�һ����������µľ����������һ��
			}
			votes += (mode == k ? 1 : -1);
		}
		return mode;
	}
}
