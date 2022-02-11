package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindSecondMinimumValue {
	public static void main(String[] args) {
		LinkedList<Integer> integers = new LinkedList<>();
		integers.addFirst(2);
		integers.getLast();
		integers.removeLast();
		System.out.println(integers.size());
	}

	public int findSecondMinimumValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> nums = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode poll = queue.poll();
			nums.add(poll.val);
			//子节点个数 0,2
			if(poll.left!=null){
				queue.add(poll.left);
				queue.add(poll.right);
			}
		}
		int[] ints = nums.stream().mapToInt(k -> k).toArray();
		Arrays.sort(ints);
		if(ints.length<=1){
			return -1;
		}
		int res=-1;
		int flag=ints[0];
		for (int i = 1; i <ints.length ; i++) {
			if(flag!=ints[i]){
				res=ints[i];
				break;
			}
		}
		return res;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}

