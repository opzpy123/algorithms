package normal;

import java.util.Arrays;

public class SearchMatrix {
	public static void main(String[] args) {
		SearchMatrix searchMatrix = new SearchMatrix();
		System.out.println(searchMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
		System.out.println(searchMatrix.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20},{23,30,34,60}}, 13));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1]) return false;
		int[] res = new int[0];
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0]<=target&&matrix[i][matrix[0].length-1]>=target){
				res=matrix[i];
			}
		}
		for (int i = 0; i < res.length; i++) {
			if(target==res[i]){
				return true;
			}
		}
		return false;
	}
}
