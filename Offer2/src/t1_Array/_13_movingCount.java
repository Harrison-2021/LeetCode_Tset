package t1_Array;

public class _13_movingCount {
//	         注意，机器人不能跳过去，故，不能通过直接遍历数组来判断，而是应该通过递归判断下个格子能否到达
//		只有能到达(i, j)格子后，才能继续走相邻的下个四个方向的格子，是并的关系，都要走一遍试试，不是或的关系
	public int movingCount(int m, int n, int k) {
		if (m <= 0 || n <= 0 || k < 0)
			return 0;
//			问题的关键是:  1.定位到具体格子，利用二维数组的连续性，用row*cols+col
//					   2，判断目标格子是否满足条件,用取余求数字，累加的方法算得数位和
//					   3，问题是一共有多少可能，不是只走一条路线，最多走多少格，因此是并的关系，都要走一遍试试，不是或的关系
		boolean[] visted = new boolean[n * m];
		for (int i = 0; i < visted.length; i++) {
			visted[i] = false; // 先将每个格子初始化为未访问状态，一旦方位，就标记为访问状态，排除重复计数
		}

		return dfs(m, n, 0, 0, visted, k);
	}

	private int dfs(int rows, int cols, int row, int col, boolean[] visted, int k) {
		int count = 0;
		// 因为当前得格子只能是从上，从左走过来的， 所以，下个格子只能往右，往下走两种情况
		if(check(rows, cols, row, col, visted, k)) {
//			要先将当前格子设置为true，防止重复访问
			visted[row * cols + col] = true;
			count = 1 + dfs(rows, cols, row + 1, col, visted, k)
			  		  + dfs(rows, cols, row, col + 1, visted, k);					
		}
		return count;
	}

	private boolean check(int rows, int cols, int row, int col, boolean[] visted, int k) {
		if(row >= rows || row < 0 || col >= cols || col < 0 ||
				sumDigit(row) + sumDigit(col) > k || visted[row * cols + col] == true) {
			return false;
		}
		return true;
	}

	private int sumDigit(int x) {
		int sum = 0;
		while(x != 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}
}
