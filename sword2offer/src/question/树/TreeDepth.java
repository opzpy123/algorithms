package question.树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为 1 。
 * <p>
 * 数据范围：节点的数量满足 0 \le n \le 1000≤n≤100 ，节点上的值满足 0 \le val \le 1000≤val≤100
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)
 * <p>
 * 假如输入的用例为{1,2,3,4,5,#,6,#,#,7}，那么如下图:
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            level++;
        }
        return level;
    }
}
