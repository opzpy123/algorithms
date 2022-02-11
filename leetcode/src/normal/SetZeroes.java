package normal;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetZeroes {
	public static void main(String[] args) {
		SetZeroes setZeroes = new SetZeroes();
		setZeroes.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
		setZeroes.setZeroes(new int[][]{{0, 1, 2, 0},
										{3, 4, 5, 2},
										{1, 3, 1, 5}});
	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m == 0 || n == 0) {
			return;
		}
		int[][] help = new int[m][n];
		for (int i = 0; i < m; i++) {
			help[i] = Arrays.copyOf(matrix[i], n);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					for (int x = 0; x < m; x++) {
						help[x][j] = 0;
					}
					for (int y = 0; y < n; y++) {
						help[i][y] = 0;
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			matrix[i] = Arrays.copyOf(help[i], n);
		}
	}
}
