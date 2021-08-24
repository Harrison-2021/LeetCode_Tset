package t4_String;

/**
 * @author ls2690069470 Offer 58 - II. 左旋转字符串
 */
public class _58_2reverseLeftWords {
	//方法一： 切片法，用n将字符串分割成两部分，然后再拼接在一起
	public String reverseLeftWords(String s, int n) {
		if(s.length() == 0 || n < 1) return " ";
		
		return s.substring(n, s.length()) + s.substring(0, n);
	}
	
	// 方法二： 列表遍历拼接
	public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
//        for(int i = n; i < s.length(); i++)
//            res.append(s.charAt(i));
//        for(int i = 0; i < n; i++)
//            res.append(s.charAt(i));
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

}
