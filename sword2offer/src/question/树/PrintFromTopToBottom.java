package question.树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 不分行从上往下打印出二叉树的每个节点，
 * 同层节点从左至右打印。例如输入{8,6,10,#,#,2,1}，
 * 如以下图中的示例二叉树，则依次打印8,6,10,2,1(空节点不打印，跳过)，
 * 请你将打印的结果存放到一个数组里面，返回。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        return res;

    }
}
