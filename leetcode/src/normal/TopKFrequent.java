package normal;

import java.util.*;

public class TopKFrequent {
	public static void main(String[] args) {
		TopKFrequent topKFrequent = new TopKFrequent();
//		System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1,1,24,34263632,51,52,35,126,2,13,2,6,5342,6,2344,643,5734,5,52315,2343}, 6)));
//		System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1}, 1)));
		System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
	}
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
		for (int num : nums) {
			occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
		}

		// int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] m, int[] n) {
				return m[1] - n[1];
			}
		});
		for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
			int num = entry.getKey(), count = entry.getValue();
			if (queue.size() == k) {
				if (queue.peek()[1] < count) {
					queue.poll();
					queue.offer(new int[]{num, count});
				}
			} else {
				queue.offer(new int[]{num, count});
			}
		}
		int[] ret = new int[k];
		for (int i = 0; i < k; ++i) {
			ret[i] = queue.poll()[0];
		}
		return ret;
	}
}
