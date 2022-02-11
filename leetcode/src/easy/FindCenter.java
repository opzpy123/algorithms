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

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i <edges.length ; i++) {
			hashMap.put(edges[i][0],hashMap.getOrDefault(edges[i][0],0)+1);
			hashMap.put(edges[i][1],hashMap.getOrDefault(edges[i][1],0)+1);
		}
		for (Integer integer : hashMap.keySet()) {
			System.out.println(integer+" "+hashMap.get(integer));
			if(hashMap.get(integer)==edges.length){
				return integer;
			}
		}
		return 0;
	}
	public int findCenter_1(int[][] edges) {
		//只判断前三组
		if (edges[0][0] == edges[1][0]) {

			return edges[0][0];
		} else if (edges[0][0] == edges[1][1]) {

			return edges[0][0];
		} else {

			return edges[0][1];
		}
	}

}
