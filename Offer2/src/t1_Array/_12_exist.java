package t1_Array;

public class _12_exist {
	// 关键是处理边界的问题，以及如何下一步递归问题
	private int rows, cols;
	public boolean exist(char[][] board, String word) {
		rows = board.length;
		cols = board[0].length;
		char[] words = word.toCharArray();
		
		for(int i = 0; i < rows; i ++) {
			for(int j = 0; j < cols; j ++) {
				if(dfs(board, words, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
		if (i >= rows || i < 0 || j >= cols || j < 0 || board[i][j] != words[k]) {
			return false;
		}
		
		if(k == words.length - 1) return true;
		
		board[i][j] = '\0';
		
		boolean res = dfs(board, words, i - 1, j, k + 1) ||
					  dfs(board, words, i + 1, j, k + 1) ||
					  dfs(board, words, i, j - 1, k + 1) ||
					  dfs(board, words, i, j + 1, k + 1);
		
		board[i][j] = words[k];
		
		return res;
	}
}
