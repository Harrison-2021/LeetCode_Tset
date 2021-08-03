package t7_LinkedList;

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
}
