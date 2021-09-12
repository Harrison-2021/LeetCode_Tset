package t3_Array;

/**
 * @author ls2690069470
 *	Offer 47. 礼物的最大价值
 */
public class _47_maxValue {
	// 动态规划思想，从简单小问题循环迭代，比直接递归，减少了重复操作，
	// 也可以用原grid数组，减少空间消耗
	public int maxValue(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		
		// 先处理第一行，第一列元素，减少判断，每个格子放路径中累加的结果
		for(int j = 1; j < m; j ++) { 
			grid[0][j] = grid[0][j] + grid[0][j - 1];
		}
		for(int i = 1; i < n; i ++) { // 先处理第一列
			grid[i][0] += grid[i - 1][0];
		}
		
		// 处理中间元素，每个元素都有两个源头，找最大的源头
		for(int i = 1; i < n; i ++) {
			for(int j = 1; j < m; j ++) {
				grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		
		return grid[n - 1][m - 1];
	}
}
