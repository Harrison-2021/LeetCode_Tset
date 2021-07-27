package t4_String;

public class Offer05 {
	// create array O(n)
	public String replaceSpace(String s) {
		int length = s.length();
		char[] array = new char[3 * length];
		int size = 0;
		for(int i = 0; i < length; i ++) {
			char c = s.charAt(i);
			if(c == ' ') {
				array[size ++] = '%';
				array[size ++] = '2';
				array[size ++] = '0';
			} else {
				array[size ++] = c;
			}
		}
		String newStr = new String(array, 0, size);
		return newStr;
    }
	
	// s.toCharArray() O(n)
	public String replaceSpace2(String s) {
		StringBuilder res = new StringBuilder();
		for(char c : s.toCharArray()) {
			if(c == ' ') res.append("%20");
			else {
				res.append(c);
			}
		}
		return res.toString();
    }
	
	// C++
	/**
	public:
    string replaceSpace(string s) {
        int count = 0, len = s.size();
        // 统计空格数量
//        int k = 0;
//        while(s[k] != '\0') {
//            if (s[k] == ' ') count++;
//            k ++;
//        }
	     for(char c : s) {
	     	if (c == ' ') count++;
	     }
	     
        // 修改 s 长度
        s.resize(len + 2 * count); // 用封装好的函数，防止长度越界，
        // 倒序遍历修改
        int i = len, j = s.size();
        while(i < j && i >= 0) {
            if (s[i] != ' ')
                s[j --] = s[i];
            else {
                s[j --] = '0';
                s[j --] = '2';
                s[j --] = '%';
            }
            i --;
        }
        return s;
    }
	 */
}
