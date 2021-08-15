package t3_Array;

/**
 * @author ls2690069470 Offer 12. 矩阵中的路径
 */
public class _12_exist {
	private int rows, cols;

	public boolean exist(char[][] board, String word) {
		rows = board.length; // 注意不能是int rows 否则是另一个变量了
		cols = board[0].length;
		
		char[] words = word.toCharArray();// 先转换为数组会提供一点效率
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(board, words, i, j, 0))
					return true;
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
		if (i >= rows || i < 0 || j >= cols || j < 0 || board[i][j] != words[k]) {
			return false;
		}
		if(k ==words.length - 1) return true;
		
		board[i][j] = '\0';
		
		boolean res = dfs(board, words, i + 1, j, k + 1) ||
					  dfs(board, words, i - 1, j, k + 1) ||
					  dfs(board, words, i, j + 1, k + 1) ||
					  dfs(board, words, i, j - 1, k + 1);
		board[i][j] = words[k]; // 判断结束后记得还原，方便下次改路径判断
		return res;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
		String word = "ABCCED";
		
		boolean res = new _12_exist().exist(board, word);
		System.out.println(res);
	}
}
