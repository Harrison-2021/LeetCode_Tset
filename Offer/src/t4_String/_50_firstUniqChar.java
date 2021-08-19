package t4_String;

import java.util.*;

/**
 * @author ls2690069470 Offer 50. 第一个只出现一次的字符
 */
public class _50_firstUniqChar {
	public char firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = s.toCharArray();

		for (char k : c) {
			if (map.containsKey(k)) {
				map.put(k, map.get(k) + 1);
			} else {
				map.put(k, 1);
			}
		}

		for (char k : c) {
			if (map.get(k) == 1) {
				return k;
			}
		}

		return ' ';
	}

	// 自定义哈希表
	static final int tableSize = 256;

	public char firstUniqChar2(String s) {
		// 用自定义的数组创建哈希表，下标索引,即字符的ASCII码为键，数组值为value
		int[] hashTable = new int[tableSize]; // 默认值为0
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i ++) {
			hashTable[c[i] - 'a'] ++; 
		}
		
		for(int i = 0; i < c.length; i ++) {
			if(hashTable[c[i] - 'a'] == 1) {
				return s.charAt(i);
			}
		}
		
		return ' ';
	}
}
