package t1_Array;

public class _47_maxValue {
	 public int maxValue(int[][] grid) {
		 int rows = grid.length; 
		 int cols = grid[0].length;
		 
		 // 先处理第一行第一列
		 for(int i = 1; i < cols; i ++) {
			 grid[0][i] += grid[0][i - 1];
		 }
		 for(int i = 1; i < rows; i ++) {
			 grid[i][0] += grid[i - 1][0];
		 }
		 
		 for(int i = 1; i < rows; i ++) {
			 for(int j = 1; j < cols; j ++) {
				 grid[i][j] += Math.max(grid[i - 1][j], grid[i][j -1]);
			 }
		 }
		 
		 return grid[rows - 1][cols - 1];
	 }
}
