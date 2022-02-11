package competeTest.week.week4_11;

import java.util.Arrays;

public class MinSideJumps {
	public static void main(String[] args) {
		System.out.println(minSideJumps(new int[]{0, 1, 2, 3, 0}));//2
		System.out.println(minSideJumps(new int[]{0,1,1,3,3,0}));//0
		System.out.println(minSideJumps(new int[]{0,2,1,0,3,0}));//2
	}
	public static int minSideJumps(int[] ob) {
		int n = ob.length;
		int[] prev = new int[3];
		int[] next = new int[3];
		int inf = (int)1e9;
		Arrays.fill(prev, inf);
		prev[1] = 0;
		for(int i = 0; i < n; i++){
			int o = ob[i];
			Arrays.fill(next, inf);
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(o - 1 == k || o - 1 == j){
						continue;
					}
					next[k] = Math.min(next[k], prev[j] + (j != k ? 1 : 0));
				}
			}
			int[] tmp = prev;
			prev = next;
			next = tmp;
		}
		int ans = Arrays.stream(prev).min().orElse(-1);
		return ans;
	}
	private static void drawTrack(int[][] track){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < track.length; j++) {
				System.out.print(track[j][i]+" ");
			}
			System.out.println();
		}
	}
}
