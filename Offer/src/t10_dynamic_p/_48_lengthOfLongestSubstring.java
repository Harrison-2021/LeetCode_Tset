package t10_dynamic_p;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ls2690069470 Offer 48. 最长不含重复字符的子字符串
 */
public class _48_lengthOfLongestSubstring {
	//动态规划、哈希表
	public int lengthOfLongestSubstring(String s) {
		if(s.length() <= 0) return 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>(); // 记录字符索引
		int temp = 0; // 记录dp[j - 1]
		int res = 0; // 更新不重复子字符串长度最大值
		
		for(int j = 0; j < s.length(); j ++) {
			int i = map.getOrDefault(s.charAt(j), -1); // 获取最近与j相等字符的索引，若没有，默认为-1
			map.put(s.charAt(j), j); // map储存最近的j的字符，索引
			temp = temp < j - i ? temp + 1 : j - i; // dp[j] 与 dp[j - 1]关系
			res = Math.max(temp, res);
		}
		
		return res;
	}
}
