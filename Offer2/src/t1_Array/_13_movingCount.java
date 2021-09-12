package t1_Array;

public class _13_movingCount {
//	         ע�⣬�����˲�������ȥ���ʣ�����ͨ��ֱ�ӱ����������жϣ�����Ӧ��ͨ���ݹ��ж��¸������ܷ񵽴�
//		ֻ���ܵ���(i, j)���Ӻ󣬲��ܼ��������ڵ��¸��ĸ�����ĸ��ӣ��ǲ��Ĺ�ϵ����Ҫ��һ�����ԣ����ǻ�Ĺ�ϵ
	public int movingCount(int m, int n, int k) {
		if (m <= 0 || n <= 0 || k < 0)
			return 0;
//			����Ĺؼ���:  1.��λ��������ӣ����ö�ά����������ԣ���row*cols+col
//					   2���ж�Ŀ������Ƿ���������,��ȡ�������֣��ۼӵķ��������λ��
//					   3��������һ���ж��ٿ��ܣ�����ֻ��һ��·�ߣ�����߶��ٸ�����ǲ��Ĺ�ϵ����Ҫ��һ�����ԣ����ǻ�Ĺ�ϵ
		boolean[] visted = new boolean[n * m];
		for (int i = 0; i < visted.length; i++) {
			visted[i] = false; // �Ƚ�ÿ�����ӳ�ʼ��Ϊδ����״̬��һ����λ���ͱ��Ϊ����״̬���ų��ظ�����
		}

		return dfs(m, n, 0, 0, visted, k);
	}

	private int dfs(int rows, int cols, int row, int col, boolean[] visted, int k) {
		int count = 0;
		// ��Ϊ��ǰ�ø���ֻ���Ǵ��ϣ������߹����ģ� ���ԣ��¸�����ֻ�����ң��������������
		if(check(rows, cols, row, col, visted, k)) {
//			Ҫ�Ƚ���ǰ��������Ϊtrue����ֹ�ظ�����
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
