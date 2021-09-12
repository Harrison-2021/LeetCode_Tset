package t1_Array;

public class _29_spiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0];
		
		// 矩阵设为闭环
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
		int index = 0;
		int[] res = new int[(r + 1) * (b + 1)];
		
		while(true) {
			for(int i = l; i <= r; i ++) { // 从左往右打印第一行
				res[index ++] = matrix[t][i];
			}
			
			if(t ++ == b) break; // 开始从上往下打印下一行，t++
			for(int i = t; i <= b; i ++) {
				res[index ++] = matrix[i][r];
			}
			
			if(r-- == l) break; // 开始从右往左打印下一列， r--
			for(int i = r; i >= l; i --) {
				res[index ++] = matrix[b][i];
			}
			
			if(b-- == t) break; // 开始从下往上打印下一行， b--
			for(int i = b; i >= t; i --) {
				res[index ++] = matrix[i][l]; 
			}
			
			if(l ++ == r) break; // 开始循环下一轮。从左往右
		}
		return res;
	}
}
