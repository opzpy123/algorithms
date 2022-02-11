package normal;

import java.util.*;

public class DistanceK {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode target = new TreeNode(5);
		target.left=new TreeNode(6);
		TreeNode treeNode = new TreeNode(2);
		treeNode.left=new TreeNode(7);
		treeNode.right=new TreeNode(4);
		target.right=treeNode;
		root.left=target;
		TreeNode treeNode1 = new TreeNode(1);
		treeNode1.left=new TreeNode(0);
		treeNode1.right=new TreeNode(8);
		root.right=treeNode1;

		DistanceK distanceK = new DistanceK();

		TreeNode treeNode2 = new TreeNode(1);
		System.out.println(distanceK.distanceK(treeNode2,treeNode2,3));
		System.out.println(distanceK.distanceK(root, target, 2));

		TreeNode treeNode3 = new TreeNode(0);
		TreeNode treeNode4 = new TreeNode(1);
		TreeNode treeNode5 = new TreeNode(3);
		TreeNode treeNode6 = new TreeNode(2);
		treeNode3.left=treeNode4;
		treeNode3.right=treeNode5;
		treeNode4.right=treeNode6;
		System.out.println(distanceK.distanceK(treeNode3, treeNode4, 2));

	}

	//	Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		if(root==target)return new ArrayList<>();
		Queue<TreeNode> queue1 = new LinkedList<>();//每次一bfs从q1->q2->q1 记录层及
		Queue<TreeNode> queue2 = new LinkedList<>();
		//寻找父节点 当作节点 一起扩散出去 父节点的子节点为自己的那一支不要扩散
		TreeNode father = findFather(root, target);
		int level = 1;
		if(target.left!=null)queue1.add(target.left);
		if(target.right!=null)queue1.add(target.right);
		if(father!=null)queue1.add(father);
		ArrayList<Integer> res = new ArrayList<>();
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			if (level == k) {
				break;
			}
			if(queue2.isEmpty()){
			while (!queue1.isEmpty()) {
				TreeNode poll = queue1.poll();
				TreeNode father1 = findFather(root, poll);
				if(father1!=null)queue2.add(father1);
				if (null!=poll.left  && poll.left != target) queue2.add(poll.left);
				if (null!=poll.right   && poll.right != target) queue2.add(poll.right);
			}
				level++;
				if (level == k) {
					break;
				}
			}

			if(queue1.isEmpty()){
				while (!queue2.isEmpty()) {
					TreeNode poll = queue2.poll();
					TreeNode father1 = findFather(root, poll);
					if(father1!=null)queue1.add(father1);
					if (poll.left != null && poll.left != target) queue1.add(poll.left);
					if (poll.right != null && poll.right != target) queue1.add(poll.right);
				}
				level++;
				if (level == k) {
					break;
				}
			}

		}
		if (!queue1.isEmpty() && queue2.isEmpty()) {
			while (!queue1.isEmpty()) {
				res.add(queue1.poll().val);
			}
		}
		if (!queue2.isEmpty() && queue1.isEmpty()) {
			while (!queue2.isEmpty()) {
				res.add(queue2.poll().val);
			}
		}
		return res;
	}

	public TreeNode findFather(TreeNode root, TreeNode target) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode pop = stack.pop();
			if (pop.left == target || pop.right == target) return pop;
			if (pop.left != null) {
				stack.push(pop.left);
			}
			if (pop.right != null) {
				stack.push(pop.right);
			}
		}
		return null;
	}
}
