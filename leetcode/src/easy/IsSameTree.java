package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSameTree {
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
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null){
			return true;
		}

		if(p!=null && q!=null && p.val==q.val  ){
			return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		}else {
			return false;
		}

	}
}
