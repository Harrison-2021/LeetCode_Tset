package t4_String;

/**
 * @author ls2690069470 Offer 20. 表示数值的字符串
 */
public class _20_isNumber {
	private int index = 0; // 用index维护字符串索引，逐步判断字符串三种字符是否符号

	public boolean isNumber(String s) {
		if(s == null || s.length() == 0) return false;
		
		// 去除字符串前面的字符串
		//if(s.charAt(index) == ' ') index ++; 
		s = s.trim() + '|'; // 增加结束标志，以便判断index是否走到了头
		 
		boolean numeric = scanInteger(s); // 首先判断是否是有符号的数字
		
		if(s.charAt(index) == '.') {
			index ++;
			// 第二步，判断小数点部分，只要前后一边有数字就行，后面数字无符号，用||
			// 为保持index++,或是短路，因此，要先判断后面的数字
			numeric = scanUnsignedInteger(s) || numeric;
		}
		
		if(s.charAt(index) == 'e' || s.charAt(index) == 'E') {
			index ++;
			// 第三步，判断指数部分，前后必须有数字，用&&，
			// 与是断路，可以先判断前面有无数字，false的话，就不用判断后面语句了
			numeric = numeric && scanInteger(s);
		}
		
		return numeric && s.charAt(index) == '|';
	}

	
	private boolean scanInteger(String s) {
		if(s.charAt(index) == '+' || s.charAt(index) == '-') {
			index ++;
		}
		return scanUnsignedInteger(s);
	}


	private boolean scanUnsignedInteger(String s) {
		int pre = index;// while循环可能不止循环一次，不能在循环内return true
		while(s.charAt(index) != '|' && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
			index ++;
		}
		return index > pre;
	}
}
