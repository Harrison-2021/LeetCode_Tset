package t1_Array;

// ʵ���϶�ά���������ʱ����ת45�ȣ�������һ�����������������֧��С���ҷ�֧����
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
