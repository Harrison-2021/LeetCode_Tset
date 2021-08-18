package t4_String;

import java.util.*;

/**
 * @author ls2690069470
 *	Offer 50. 第一个只出现一次的字符
 */
public class _50_firstUniqChar {
	public char firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = s.toCharArray();
		
		for(char k : c) {
			if(map.containsKey(k)) {
				map.put(k, map.get(k) + 1);
			} else {
				map.put(k, 1);
			}
		}
		
		for(char k : c) {
			if(map.get(k) == 1) {
				return k;
			}
		}
		
		return ' ';
	}
}
