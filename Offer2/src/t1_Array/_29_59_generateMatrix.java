package t1_Array;

public class _29_59_generateMatrix {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n]; // ����Ҫ���صĶ�ά����
		int[] res = new int[n*n];	    // ��ά����Ҫ�洢������
		for(int i = 0; i < res.length; i ++) {
			res[i] = i + 1;
		}
		
		int l = 0, r = n - 1, t = 0, b = n -1;
		int index = 0;
		while(true) {
			for(int i = l; i <= r; i ++) { // �������Ҵ�ӡ��һ��
				matrix[t][i] = res[index ++];
			}
			
			if(t ++ == b) break; // ��ʼ�������´�ӡ��һ�У�t++
			for(int i = t; i <= b; i ++) {
				matrix[i][r] = res[index ++];
			}
			
			if(r-- == l) break; // ��ʼ���������ӡ��һ�У� r--
			for(int i = r; i >= l; i --) {
				matrix[b][i] = res[index ++];
			}
			
			if(b-- == t) break; // ��ʼ�������ϴ�ӡ��һ�У� b--
			for(int i = b; i >= t; i --) {
				matrix[i][l] = res[index ++]; 
			}
			
			if(l ++ == r) break; // ��ʼѭ����һ�֡���������
		}
		return matrix;
	}
}
