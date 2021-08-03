package t8_bitOperation;

/**
 * @author ls2690069470
 *	二进制中1的个数
 */
public class _15_hammingWeight {
	 public int hammingWeight(int n) {
		 // 转为字符串法 O(n)
		 String binaryStr = Integer.toBinaryString(n);
		 
		 int count = 0;
		 for(int i = 0; i < binaryStr.length(); i ++) {
			 char c = binaryStr.charAt(i);
			 if(c == '1') {
				 count ++;
			 }
		 }
		 
		 return count;
	 }
	 
	 public int hammingWeight2(int n) {
		 // 位运算法
		 int count = 0;
//		 for(int i = 0; i < 32; i ++) {
//			 int mark = 1 << i; // 左移i位，低位取0， 高位取1
//			 if((n & mark) != 0) { // 每次从低到高进行比较一位，同为1.为1，否则为0
//				 count ++;
//			 }
//		 }
		 
		 while(n != 0) {
			 count += (n & 1);
			 n >>>= 1; // java 中无符号右移>>>=
		 }
		 return count;
	 }
	 
	 public int hammingWeight3(int n) {
		 int count = 0;
		 while(n != 0) {
			 n = n & (n -1);
			 n = 0xffffffff & n;
			 count ++;
		 }
		 return count;
	 }
}
