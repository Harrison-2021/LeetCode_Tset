package t3_Array;


/**
 * @author ls2690069470
 *	 Offer 29. 顺时针打印矩阵
 */
public class _29_spiralOrder {
//	考察对二维数组结构的熟悉，顺时针打印，实质是对数组的边界消除工作，可以先定义四个边的变量
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0];
		
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
		int x = 0; // 定义好索引，结果索引
		int[] res = new int[(r + 1) * (b + 1)];
		
		while(true) {
			for(int i = l; i <= r; i ++) { // left to right
				res[x ++] = matrix[t][i];
			}
			
			// 每次错一位，即行或列要增加1时，遍历前，都要先判断是否越界
			if(t++ == b) break; // 默认t <= b, l <= r，如果只有一行，一列，t=b=0，l=r=0故要先判断
			                    // 等价为 if(t == b) break; t ++;
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
