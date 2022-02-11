package normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
	public static void main(String[] args) {
		NetworkDelayTime networkDelayTime = new NetworkDelayTime();
		System.out.println(networkDelayTime.networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2));
	}
	public int networkDelayTime(int[][] times, int n, int k) {
		int[] arr = new int[n+1];
		int res=0;
		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		for (int i = 0; i < times.length; i++) {
			if(times[i][0]==k){
				queue.add(times[i]);
				arr[times[i][0]]++;
			}
		}
		while (!queue.isEmpty()){
			int[] poll = queue.poll();
			arr[poll[1]]++;

			int next = poll[1];
			for (int j = 0; j < times.length; j++) {
				if(times[j][0]==next){
					queue.add(times[j]);
				}
			}
			res+=poll[2];
		}

		for (int i = 1; i < n+1; i++) {
			if(arr[i]==0){
				return -1;
			}
		}
		return res;
	}
}
