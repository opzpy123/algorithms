package easy;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
	List<Integer> res = new ArrayList<Integer>();
	public TreeNode increasingBST(TreeNode root) {
		dfs(root);
		TreeNode dummyNode = new TreeNode(-1);
		TreeNode currNode = dummyNode;
		for (int value : res) {
			currNode.right = new TreeNode(value);
			currNode = currNode.right;
		}
		return dummyNode.right;
	}
	private void dfs(TreeNode root){
		if (root==null){
			return;
		}
		dfs(root.left);
		res.add(root.val);
		dfs(root.right);
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
