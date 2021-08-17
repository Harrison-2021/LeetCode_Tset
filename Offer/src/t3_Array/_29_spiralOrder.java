package t3_Array;


/**
 * @author ls2690069470
 *	 Offer 29. 顺时针打印矩阵
 */
public class _29_spiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0];
		
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
		int x = 0;
		int[] res = new int[(r + 1) * (b + 1)];
		
		while(true) {
			for(int i = l; i <= r; i ++) { // left to right
				res[x ++] = matrix[t][i];
			}
			if(t++ == b) break; // 默认t < b, l < r
			
			for(int i = t; i <= b; i ++) { // top to bottom
				res[x ++] = matrix[i][r];
			}
			if(r-- == l) break;
			
			for(int i = r; i >= l; i --) { // right to left
				res[x ++] = matrix[b][i];
			}
			if(b-- == t) break;
			
			for(int i = b; i >= t; i --) { // bottom to top
				res[x ++] = matrix[i][l];
			}
			if(l++ == r) break;
		}
		return res;
	}
}
