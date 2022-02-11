package easy;

import java.util.*;

public class LeafSimilar {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		//广度优先搜索两个树的叶子节点 放入List 判断两个list是否一致
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		ArrayList<Integer> list_1 = new ArrayList<>();
		ArrayList<Integer> list_2 = new ArrayList<>();
		stack1.add(root1);
		stack2.add(root2);
		while (!stack1.isEmpty()){
			TreeNode poll = stack1.pop();
			if(poll.left==null&&poll.right==null)list_1.add(poll.val);
			if(poll.left!=null) stack1.add(poll.left);
			if(poll.right!=null) stack1.add(poll.right);
		}
		while (!stack2.isEmpty()){
			TreeNode poll = stack2.pop();
			if(poll.left==null&&poll.right==null)list_2.add(poll.val);
			if(poll.left!=null) stack2.add(poll.left);
			if(poll.right!=null) stack2.add(poll.right);
		}
		System.out.println(list_1);
		System.out.println(list_2);
		return list_1.equals(list_2);
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
