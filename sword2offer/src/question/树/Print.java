package question.树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 按之字形顺序打印二叉树
 * 描述
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * <p>
 * 数据范围：0 \le n \le 15000≤n≤1500,树上每个节点的val满足 |val| <= 100∣val∣<=100
 * 要求：空间复杂度：O(n)O(n)，时间复杂度：O(n)O(n)
 * 例如：
 * 给定的二叉树是{1,2,3,#,#,4,5}
 */
public class Print {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        Print print = new Print();
        ArrayList<ArrayList<Integer>> print1 = print.print(treeNode);
        for (ArrayList<Integer> integers : print1) {
            System.out.println(integers);
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int flag = 1;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                integers.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            if (flag++ % 2 == 0) {
                Collections.reverse(integers);
            }
            res.add(integers);
        }
        return res;
    }
}
