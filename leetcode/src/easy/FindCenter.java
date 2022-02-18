package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class FindCenter {
	public static void main(String[] args) {
		FindCenter findCenter = new FindCenter();
		System.out.println(findCenter.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
	}
	public int findCenter(int[][] edges) {
		return edges[0][0]==edges[1][1]||edges[0][0]==edges[1][0]?edges[0][0]:edges[0][1];
	}

}
