package normal;

import java.util.*;

public class PathInZigZagTree {
	public List<Integer> pathInZigZagTree(int label) {
//		//双队列
//		Deque<TreeNode> deque = new LinkedList<>();
//		//模拟构建二叉树
//		int step = 1;
//		TreeNode root = new TreeNode(step);
//		TreeNode pre = root;
//		deque.add(root);
//		boolean flag = true;
//		while (true) {
//			if (step == label) break;
//			TreeNode poll = deque.poll();
//			TreeNode treeNodeLeft = new TreeNode(step++);
//			poll.left = treeNodeLeft;
//			if (step == label) break;
//			TreeNode treeNodeRight = new TreeNode(step++);
//			poll.right = treeNodeRight;
//			if (step == label) break;
//			if (flag) {
//				flag = false;
//				deque.add(treeNodeLeft);
//				deque.add(treeNodeRight);
//			} else {
//				flag = true;
//				deque.add(treeNodeRight);
//				deque.add(treeNodeLeft);
//			}
//		}
//
//		//pre深度优先遍历查找label
//		Stack<TreeNode> stack = new Stack<>();
//		stack.push(pre);
		//思路 数学去找每一层的元素 找到所在层数
		//1 23 4567 8-15
		//如果是奇数层则不动 按

		return null;

	}

	class TreeNode {
		private Integer value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(Integer value) {
			this.value = value;
		}
	}
}
