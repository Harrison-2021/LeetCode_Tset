package t8_bitOperation;

/**
 * @author ls2690069470
 *	Offer 65. 不用加减乘除做加法
 */
public class _65_add {
	 public int add(int a, int b) {
//		 int xorNum = a ^ b;
//		 int andNum = (a & b) << 1;
//		 
//		 while(andNum != 0) {
//			 int tempXor = xorNum ^ andNum;
//			 andNum = (xorNum & andNum) << 1;
//			 xorNum = tempXor;
//		 }
//		 
//		 return xorNum;
		while(b != 0) {
			int c = (a & b) << 1;
			a = a ^ b;
			b = c;
		}
		return a;
	 }
}
