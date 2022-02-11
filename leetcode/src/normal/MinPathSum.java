package normal;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }


        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int dp[][] = new int[maxRow][maxCol];
        dp[0][0] = grid[0][0];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                if (row == 0 && col != 0) {
                    dp[row][col] = grid[row][col] + dp[row][col - 1];
                } else if (col == 0 && row != 0) {
                    dp[row][col] = grid[row][col] + dp[row - 1][col];
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
                }
            }
        }

        return dp[maxRow - 1][maxCol - 1];
    }
}
