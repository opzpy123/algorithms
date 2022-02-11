package normal;

public class FindNumberIn2DArray {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(matrix[i][j]==target){
					return true;
				}
				if(matrix[i][j]>target&&i<row){
					i++;
					j=0;
				}
			}
		}
		return false;
	}
}
