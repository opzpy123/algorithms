package normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTIterator {
	//中序遍历树
	int index=0;
	List<Integer> list = new ArrayList<>();

	public BSTIterator(TreeNode root) {
		inorderTraversal(root,list);
	}

	public int next() {
		if(index>list.size()){
			return 0;
		}
		return list.get(index++);
	}

	public boolean hasNext() {
		return index<list.size();
	}

	private void inorderTraversal(TreeNode root,List<Integer> arr){
		if(root==null) return;
		inorderTraversal(root.left,arr);
		arr.add(root.val);
		inorderTraversal(root.right,arr);


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
