package question.树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的镜像
 * <p>
 * 描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 数据范围：二叉树的节点数 0 \le n \le 10000≤n≤1000 ， 二叉树每个节点的值 0\le val \le 10000≤val≤1000
 * 要求： 空间复杂度 O(n)O(n) 。本题也有原地操作，即空间复杂度 O(1)O(1) 的解法，时间复杂度 O(n)O(n)
 */
public class Mirror {

    public TreeNode Mirror(TreeNode pRoot) {
        if(pRoot==null)return pRoot;
        // write code here
        //层序遍历 对于每个节点交换其左右节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode tmp = poll.left;
            poll.left = poll.right;
            poll.right = tmp;
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        return pRoot;
    }
}
