package t1_Array;

public class _29_spiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0];
		
		// ������Ϊ�ջ�
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
		int index = 0;
		int[] res = new int[(r + 1) * (b + 1)];
		
		while(true) {
			for(int i = l; i <= r; i ++) { // �������Ҵ�ӡ��һ��
				res[index ++] = matrix[t][i];
			}
			
			if(t ++ == b) break; // ��ʼ�������´�ӡ��һ�У�t++
			for(int i = t; i <= b; i ++) {
				res[index ++] = matrix[i][r];
			}
			
			if(r-- == l) break; // ��ʼ���������ӡ��һ�У� r--
			for(int i = r; i >= l; i --) {
				res[index ++] = matrix[b][i];
			}
			
			if(b-- == t) break; // ��ʼ�������ϴ�ӡ��һ�У� b--
			for(int i = b; i >= t; i --) {
				res[index ++] = matrix[i][l]; 
			}
			
			if(l ++ == r) break; // ��ʼѭ����һ�֡���������
		}
		return res;
	}
}
