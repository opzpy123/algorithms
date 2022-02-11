package question.树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        //层序遍历 保存上一次的值 每次取值与上一次作比较 如果小于则false 如果大于 则更新flag;
        if (root == null) return true;

        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        int tmp = root.val;
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            if (poll.val < tmp) return false;
            else tmp = poll.val;
            if (poll.left != null) list.add(poll.left);
            if (poll.right != null) list.add(poll.right);
        }
        return true;
    }
}
