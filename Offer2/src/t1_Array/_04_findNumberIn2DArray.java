package t1_Array;

// 实质上二维数组矩阵，逆时针旋转45度，就类似一个二叉搜索树，左分支都小，右分支都大
public class _04_findNumberIn2DArray {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
			return false;
		}
		
		int rows = matrix.length, cols = matrix[0].length;
		int i = 0, j = cols - 1;
		while(i < rows && j >= 0) {
			if(matrix[i][j] == target) {
				return true;
			} else if(matrix[i][j] > target) {
				j --;
			} else {
				i ++;
			}
		}
		return false;
	}
}
