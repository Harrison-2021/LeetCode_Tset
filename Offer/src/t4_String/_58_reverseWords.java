package t4_String;


/**
 * @author ls2690069470
 *	offer 58_1 字符串的翻转
 */
public class _58_reverseWords {
//	双指针法，既然是翻转，可以定义指针从后往前遍历，单词由字符组成，需要两个指针，一个指前，一个只后
	 public String reverseWords(String s) {
		 if(s == null || s.length() == 0) return "";
		 String str = s.trim();
		 StringBuilder res = new StringBuilder();
		 int i = str.length() - 1, j = i;
		 
		 while(i >= 0) {
			 while(i >= 0 && str.charAt(i) != ' ') i --; // 从右开始遇到第一个空格，i指向该空格，小循环里也要保证下标不能越界
			 res.append(str.substring(i + 1, j + 1) + ' '); // 注意输出的单词格式，单词间要有空格
			 while(i >= 0 && str.charAt(i) == ' ') i --; // 跳过与下个单词间的所有空格，i指向新单词的结尾
			 j = i; // 维护j指向单词结尾
		 }
		 
		 return res.toString().trim();
	 }
	 
//	 方法二，应用库函数split(),分割出单词，再倒叙加入res中输出
	 public String reverseWords2(String s) {
		 if(s == null || s.length() == 0) return "";
		 String[] str = s.trim().split(" ");
		 StringBuilder res = new StringBuilder();
		 for(int i = str.length - 1; i >= 0; i--) {
			 if(str[i].equals("")) continue; // 遇到空单词，跳过
			 res.append(str[i] + " ");
		 }
		 return res.toString().trim();
	 }
}
