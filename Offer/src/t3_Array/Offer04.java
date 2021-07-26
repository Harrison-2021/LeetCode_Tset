package t3_Array;

public class Offer04 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// O(n^2)
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean findNumberIn2DArray2(int[][] matrix, int target) {		
		// O(n)
		// java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

		int rows = matrix.length;
		int columns = matrix[0].length;// matrix[0] must not be null
		int i = 0, j = columns - 1; 
		while(i < rows && j >= 0) { 
			int num = matrix[i][j];
			if(num == target) {
				return true;
			} else if(num < target) {
				i ++;
			} else {
				j --;
			}			
		}
		return false;
	}
	
	public boolean findNumberIn2DArray3(int[][] matrix, int target) {		
		// O(n)
		int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {};
		Offer04 offer = new Offer04();
		System.out.println(offer.findNumberIn2DArray3(matrix, 50));
	}
}
