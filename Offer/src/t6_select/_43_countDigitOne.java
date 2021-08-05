package t6_select;

/**
 * @author ls2690069470
 *	Offer 43. 1～n 整数中 1 出现的次数
 */
public class _43_countDigitOne {
	// 方法一： 累加1~n中每个数1出现的次数，依次拿出每个数的各位，判断累加即可，O(nlogn)
	 public int countDigitOne(int n) {
		 int count = 0;
		 for(int i = 1; i <= n; i ++) {
			 count += NumberOf1(i);
		 }
		 return count;
	 }
	 
	 private int NumberOf1(int n) {
		 int count = 0;
		 while(n != 0) {
			 if(n % 10 == 1) {
				 count ++;
			 } 
			 n = n / 10;
		 }
		 return count;
	 }
	 
	 // 方法二：归纳迭代法，O(logn)
	 // 从个位开始循环，按住一个位，设定为1，找到所有排列组合，再找十位，依次找到最高位，将所有结果相加
	 // 因此，需要维护当前变量cur,高位high,低位low,
	 // 以及确定高位组合(非00...-99...）后，低位组合的(00...-99...)10的i次方，将两种组合相乘
	 public int countDigitOne2(int n) {
		 int digit = 1; // 初始找个位为1的所有组合情况 digit = 10^i
		 int cur = n % 10;
		 int high = n / 10;
		 int low = 0;
		 int res = 0;
		 
		 while(high != 0 || cur != 0) { // 循环终止条件是cur找到了最高位，处理完后(cur = high) % 10 = 0
			 // cur当前与1的大小比较有三种情况，会有三种组合情况
			 // 当cur = 1,如2314，高位23两种情况，当高位是00-22共23种排列时，低位有0-9共10^1种排列，共23*10，
			 //								当高位23,低位只有0-45种，共23*10+5
			 //	当cur < 1, 如2304，高位23两种情况，当高位是00-22共23种排列时，低位有0-9共10^1种排列，共23*10，
			 //								当高位23,2310大于2304，没有组合
			 //	当cur > 1, 如2324，高位23两种情况，当高位是00-22共23种排列时，低位有0-9共10^1种排列，共23*10，
			 //								当高位23,低位0-9，10种组合，共23*10+10,即23*digit+digit
			 if(cur == 1) {
				 res += high * digit + low + 1;
			 } else if(cur == 0) {
				 res += high * digit;
			 } else {
				 res += high * digit + digit;
			 }
			 
			 // 从低位到高位依次推进，进行下一位的循环判断查找
			 low = low + cur * digit;
			 cur = high % 10;
			 high = high / 10;
			 digit = digit * 10;			 
		 }
		 return res;
	 }
}
