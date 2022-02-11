package question.树;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root,sum);
    }

    private boolean helper(TreeNode root,int target){
        if(root==null)return false;
        target-=root.val;
        if(root.left==null&&root.right==null&&target==0)return true;
        return helper(root.left,target)||helper(root.right,target);
    }
}
