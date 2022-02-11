package normal;

import java.util.Arrays;

public class GenerateMatrix {
	public static void main(String[] args) {
		GenerateMatrix generateMatrix = new GenerateMatrix();
		generateMatrix.generateMatrix(3);
	}

	public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		int[] dx={0,1,0,-1},dy={1,0,-1,0};
		int startX=0,startY=0,d=0;
		for (int i = 0; i < n * n; i++) {
			ans[startX][startY]=i+1;
			int currentX = startX+dx[d],currentY=startY+dy[d];
			if(currentX<0||currentY<0||currentX>=n||currentY>=n||ans[currentX][currentY]!=0){
				d=(d+1)%4;
			}
			startX = startX + dx[d];
			startY = startY + dy[d];
		}
		return ans;
	}
}
