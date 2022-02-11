package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RestoreArray {
	public static void main(String[] args) {
		RestoreArray restoreArray = new RestoreArray();
		System.out.println(Arrays.toString(restoreArray.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 1}})));
//		System.out.println(Arrays.toString(restoreArray.restoreArray(new int[][]{{4,-2}, {1, 4}, {-3, 1}})));
//		System.out.println(Arrays.toString(restoreArray.restoreArray(new int[][]{{1000000, -1000000}})));
	}

	public int[] restoreArray(int[][] adjacentPairs) {
		int n = adjacentPairs.length + 1;
		int[] res = new int[n];
		Deque<Integer> resQueue = new LinkedList<>();
		Deque<int[]> tempQueue = new LinkedList<>();
		for (int[] adjacentPair : adjacentPairs) {
			tempQueue.push(adjacentPair);
		}
		int[] last = tempQueue.peek();
		resQueue.addLast(last[0]);
		while (!tempQueue.isEmpty()) {
			int l = resQueue.peekFirst();
			int r = resQueue.peekLast();
			int[] pop = tempQueue.pop();
			if (l == pop[1]) {
				resQueue.addFirst(pop[1]);
			} else if (r == pop[0]) {
				resQueue.addLast(pop[0]);
			} else if (l == pop[0]) {
				//遍历队列 从前向后
				int num = pop[1];
				int[] arr = new int[1];
				for (Integer integer : resQueue) {
					arr[arr.length-1]=integer;
					arr=new int[arr.length+1];
				}


			} else if (r == pop[1]) {
				//遍历队列 从后向前
				int num = pop[0];
				ArrayList<Integer> integers = new ArrayList<>();

			} else {
				tempQueue.addLast(pop);
			}
		}
		int idx = 0;
		for (Integer integer : resQueue) {
			res[idx++] = integer;
		}
		return res;

	}
}
