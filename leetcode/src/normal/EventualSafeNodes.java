package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeNodes {
	public static void main(String[] args) {
		EventualSafeNodes eventualSafeNodes = new EventualSafeNodes();
		eventualSafeNodes.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
		eventualSafeNodes.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}});
	}

	public static List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> ans = new ArrayList<Integer>();//记录结果
		int n = graph.length;//长度
		int[] type = new int[n];//访问类型
		for (int i = 0; i < n; i++) {
			if (DFS(graph, i, type) == 2) ans.add(i);
		}
		return ans;
	}

	public static int DFS(int[][] graph, int index, int[] type) {
		if (type[index] == 1) return 3;//如果访问过了，说明成环
		if (type[index] != 0) return type[index];    //如果不是0，返回自身
		type[index] = 1;//标记访问了
		for (int i : graph[index]) {
			if (DFS(graph, i, type) == 3) {
				type[i] = 3;
				return 3;
			}
		}

		type[index] = 2;//不成环
		return 2;
	}
}