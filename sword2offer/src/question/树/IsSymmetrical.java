package question.树;

import common.TreeNode;

/**
 * 对称的二叉树
 */
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return helper(pRoot.left,pRoot.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        if((left==null&&right!=null)||(left!=null&&right==null)){
            return false;
        }
        if(left==null&&right==null)return true;
        if(left.val!=right.val)return false;
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }
}
