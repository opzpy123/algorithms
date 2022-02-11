package competeTest.week.week4_17;

import java.util.Arrays;

public class CountPoints {
	public static void main(String[] args) {
		countPoints(new int[][]{{1,3},{3,3},{5,3},{2,2}},new int[][]{{2,3,1},{4,3,1},{1,1,2},});
	}
	public static int[] countPoints(int[][] points, int[][] queries) {
		int[] count= new int[queries.length];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < queries.length; j++) {
				if(Math.pow(points[i][0]-queries[j][0],2)+Math.pow(points[i][1]-queries[j][1],2)<=Math.pow(queries[j][2],2)){
					count[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		return count;
	}
}
