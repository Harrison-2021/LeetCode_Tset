package t8_bitOperation;

/**
 * @author ls2690069470
 *	Offer 56 - I. 数组中数字出现的次数
 */
public class _56_1singleNumbers {
	public int[] singleNumbers(int[] nums) {
		if(nums == null || nums.length < 2) {
			return null;
		}
		
		// 第一步，先用位运算将数组分组，分组条件是1的位置
		int resultXor = 0;
		for(int i = 0; i < nums.length; i ++) {
			resultXor ^= nums[i];
		}
		
		int indexOf1 = findFirstBitls1(resultXor);
		
		// 第二步，每组中，依次异或处理，留下的那个数，就是只出现一次的数
		int num1 = 0, num2 = 0;
		for(int i = 0; i < nums.length; i ++) {
			if(isBit1(nums[i], indexOf1)) {
				num1 ^= nums[i];
			} else {
				num2 ^= nums[i];
			}
		}
		
		int[] res = new int[2];
		res[0] = num1;
		res[1] = num2;
		return res;
		
	}

	private int findFirstBitls1(int num) {
		int indexBit = 0;
		while((num & 1) == 0 && indexBit < 32) {
			num = num >> 1;
			indexBit ++;
		}
		return indexBit;
	}

	private boolean isBit1(int num, int indexOf1) {
		num = num >> indexOf1;
		return (num & 1) == 1;
	}
}
