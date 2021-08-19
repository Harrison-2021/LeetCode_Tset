package t4_String;


/**
 * @author ls2690069470
 *	Offer 44. 数字序列中某一位的数字
 */

public class _44_findNthDigit {
	// 方法一： 根据数字规律，定位到多少位，再精确定位到数字，再定位到数字中的第几位
	public int findNthDigit(int n) {
		// 首先，根据n定位到多少位的数，digit
		int digits = 1; 
		while(true) {
			// 注意求得digits位得数字可能很大，int型会越界，要用long来储存
			long countNum = countOfDigit(digits); // 确定digit位的数字一共有多少个
			if(n < countNum * digits) { // 初始是一位数的最多个数，10个，0-9，如果在这10个数内，再精确到具体10进制数
				long nums = beginDig(digits) + n / digits;
				int indexFromRight = digits - n % digits;
				for(int i = 1; i < indexFromRight; i ++) {
					nums = nums / 10;
				}
				return (int)nums % 10; // 相除取余后，nums变得很小，结果也很小，可以转化为int，不会失真
			}
			n = n - (int)(digits * countNum); // 如果n > countNum * digits,寻早下一位数字范围
			digits ++;
		}
	}

	private long countOfDigit(int digits) {
		if(digits == 1) {
			return 10;
		}
		return 9 * (long)Math.pow(10, digits - 1);
	}

	private long beginDig(int digits) {
		if(digits == 1) return 0;
		return (long)Math.pow(10, digits - 1);
	}
	
	// 可以先把0去掉，简化代码
	public int findNthDigit2(int n) {
		int digits = 1;
		long start = 1; // 从1开始，n从0开始，因此，n表示比目标值大1，方便循环
		long count = 9; // 从1开始，一位数有9个
		
		while(n > count) { // 1.先找数，先找数得范围，即是几位数
			n -= count;
			digits ++;
			start *= 10;
			count = digits * start * 9;
		}
		
		long num = start + (n -1) / digits; // 2.找到十进制中得数
		
		return Long.toString(num).charAt((n - 1) % digits) - '0'; // 先得到字符ASCII码，要减去偏移量，才能得到int型数
	}
}
