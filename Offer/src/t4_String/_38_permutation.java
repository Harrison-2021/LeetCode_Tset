package t4_String;

import java.util.*;

/**
 * @author ls2690069470
 *	Offer 38. 字符串的排列
 */
public class _38_permutation {
	private List<String> res = new LinkedList<String>();
	private char[] c;
	
	public String[] permutation(String s) {
		if(s == null) return null;
		
		
		c = s.toCharArray();
		dfs(0);
		
		return res.toArray(new String[res.size()]);
		
	}

	private void dfs(int x) {
		if(x == c.length - 1) {
			res.add(String.valueOf(c));
			return;
		}
		
		Set<Character> set = new HashSet<Character>();
		for(int i = x; i < c.length; i ++) {
			if(set.contains(c[i])) continue;
			
			set.add(c[i]);
			swap(i, x);
			dfs(x + 1);
			swap(i, x);
		}
		
	}

	private void swap(int i, int x) {
		char temp = c[i];
		c[i] = c[x];
		c[x] = temp;
		
	}
}
