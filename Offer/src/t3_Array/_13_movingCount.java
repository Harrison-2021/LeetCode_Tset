package t3_Array;

/**
 * @author ls2690069470 Offer 13. 机器人的运动范围
 */
public class _13_movingCount {
	// 注意，机器人不能跳过去，故，不能通过直接遍历数组来判断，而是应该通过递归判断下个格子能否到达
	// 只有能到达(i, j)格子后，才能继续走相邻的下个四个方向的格子，是并的关系，都要走一遍试试，不是或的关系
	public int movingCount(int m, int n, int k) {
		// 如果走到之前走过的格子，不能重复计数
		boolean[] visted = new boolean[m * n];
		for(int i = 0; i < visted.length; i ++) {
			visted[i] = false;
		}
		
		return movingCnt(m, n, 0, 0, visted, k);
	}

	private int movingCnt(int rows, int cols, int row, int col, boolean[] visted, int k) {
		int count = 0;
		
		if(check(rows, cols, row, col, visted, k)) {
			visted[row * cols + col] = true;
			count = 1 + movingCnt(rows, cols, row - 1, col, visted, k) 
					  + movingCnt(rows, cols, row + 1, col, visted, k) 
					  + movingCnt(rows, cols, row, col - 1, visted, k)
					  + movingCnt(rows, cols, row, col + 1, visted, k);
		}
		
		return count;
	}

	private boolean check(int rows, int cols, int row, int col, boolean[] visted, int k) {
		if (row >= rows || row < 0 || col >= cols || col < 0 
				|| getDigitSum(row) + getDigitSum(col) > k || visted[row * cols + col] == true) {
			return false;
		}
		return true;
	}

	private int getDigitSum(int x) {
		int sum = 0;
		while (x != 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}
}
