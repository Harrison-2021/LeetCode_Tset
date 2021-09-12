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

	// 关键是处理边界的问题，以及如何下一步递归问题
	private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
		if (i >= rows || i < 0 || j >= cols || j < 0 || board[i][j] != words[k]) {
			return false;
		}
		if(k ==words.length - 1) return true;
		
		board[i][j] = '\0'; // 先将当前元素标记为空字符，放在再次被匹配访问
		
		boolean res = dfs(board, words, i + 1, j, k + 1) ||
					  dfs(board, words, i - 1, j, k + 1) ||
					  dfs(board, words, i, j + 1, k + 1) ||
				dfs(board, words, i, j - 1, k + 1); /* 分别找上下左右位置，只要找到一个就可 */
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
