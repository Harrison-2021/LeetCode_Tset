package t4_String;


/**
 * @author ls2690069470
 *	Offer 45. 把数组排成最小的数
 */
public class _45_minNumber {
	 public String minNumber(int[] nums) {
		 String[] str = new String[nums.length];
		 for(int i = 0; i < nums.length; i ++) {
			 str[i] = String.valueOf(nums[i]);
		 }
		 
		 StringBuilder res = new StringBuilder();
		 		 
		 quickSort(str, 0, str.length - 1);
		 
		 for(String s : str) {
			 res.append(s);
		 }
		 
		 return res.toString();
	 }

	private void quickSort(String[] str, int l, int r) {
		if(l >= r) return;
		
		int i = l + 1, j = r;
		while(true) {
			while(i <= j && (str[i] + str[l]).compareTo(str[l] + str[i]) <= 0) i ++;
			while(i <= j && (str[j] + str[l]).compareTo(str[l] + str[j]) >= 0) j --;
			
			if(i >= j) break;
			
			if(!str[i].equals(str[j])) swap(str, i, j);
			
			i ++; j--;
		}
		
		swap(str, l, j);
		
		quickSort(str, l, j - 1);
		quickSort(str, j + 1, r);
		
	}

	private void swap(String[] str, int i, int j) {
		String temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		
	}
}
