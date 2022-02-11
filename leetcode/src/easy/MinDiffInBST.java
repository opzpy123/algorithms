package easy;

import java.util.ArrayList;
import java.util.List;

public class MinDiffInBST {
	List<Integer> list = new ArrayList<>();
	public int minDiffInBST(TreeNode root) {
		dfs(root);
		int preVal = list.get(0);
		int res=list.get(1)-list.get(0);
		for (int i = 1; i < list.size(); i++) {
			res=Math.min(list.get(i)-preVal,res);
			preVal=list.get(i);
		}
		return res;
	}
	private void dfs(TreeNode root){
		if(root==null){
			return;
		}
		dfs(root.left);
		list.add(root.val);
		dfs(root.right);

	}

//	 Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
}
