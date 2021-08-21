package t4_String;


/**
 * @author ls2690069470
 *	Offer 46. 把数字翻译成字符串
 */
public class _46_translateNum {
	// 从后往前遍历，用迭代代替递归，节省空间，减少重复操作
	public int translateNum(int num) {
		if(num < 0) return 0;
		
		String s = String.valueOf(num);
		return getTranslationCount(s);
	}

	private int getTranslationCount(String s) {
		char[] nums = s.toCharArray();
		int count = 0; // 用来记录当前数字的翻译次数
		int len = nums.length;
		int[] preCnts = new int[len]; // 用来记录之前的数字翻译可能数
				
		for(int i = len - 1; i >= 0; i --) {
			count = 0; // 每个数字都要判断，每次都要初始话
			
			if(i < len - 1) {
				count = preCnts[i + 1]; // 记录当前数字只翻译一个的情况，等于之前的所有可能
			} else {
				count = 1; // 右边的第一个数字翻译次数
			}
			
			if(i < len - 1) {
				int digit1 = nums[i] - '0';
				int digit2 = nums[i + 1] - '0';
				int convered = digit1 * 10 + digit2;
				
				if(convered >= 10 + digit2 && convered <= 25) {
					if(i < len - 2) {
						count += preCnts[i + 2]; // 连同 i+1 的翻译结果加上之前i + 2的翻译结果
					} else {
						count += 1;
					}
				}
			}
			
			preCnts[i] = count;
		}
		
		return preCnts[0];
	}
}
