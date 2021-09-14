package t1_Array;

public class _29_59_generateMatrix {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n]; // 定义要返回的二维数组
		int[] res = new int[n*n];	    // 二维数组要存储的数据
		for(int i = 0; i < res.length; i ++) {
			res[i] = i + 1;
		}
		
		int l = 0, r = n - 1, t = 0, b = n -1;
		int index = 0;
		while(true) {
			for(int i = l; i <= r; i ++) { // 从左往右打印第一行
				matrix[t][i] = res[index ++];
			}
			
			if(t ++ == b) break; // 开始从上往下打印下一行，t++
			for(int i = t; i <= b; i ++) {
				matrix[i][r] = res[index ++];
			}
			
			if(r-- == l) break; // 开始从右往左打印下一列， r--
			for(int i = r; i >= l; i --) {
				matrix[b][i] = res[index ++];
			}
			
			if(b-- == t) break; // 开始从下往上打印下一行， b--
			for(int i = b; i >= t; i --) {
				matrix[i][l] = res[index ++]; 
			}
			
			if(l ++ == r) break; // 开始循环下一轮。从左往右
		}
		return matrix;
	}
}
