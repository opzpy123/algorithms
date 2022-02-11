package question.树;

import common.TreeNode;

/**
 * 二叉搜索树的第k个节点
 * <p>
 * 描述
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 * <p>
 * <p>
 * 数据范围： 0 \le n \le10000≤n≤1000，0 \le k \le10000≤k≤1000，树上每个结点的值满足0 \le val \le 10000≤val≤1000
 * 进阶：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * <p>
 * 如输入{5,3,7,2,4,6,8},3时，二叉树{5,3,7,2,4,6,8}如下图所示：
 * <p>
 * 该二叉树所有节点按结点值升序排列后可得[2,3,4,5,6,7,8]，所以第3个结点的结点值为4，故返回对应结点值为4的结点即可。
 */
public class KthNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        KthNode kthNode = new KthNode();
        int i = kthNode.KthNode(treeNode, 3);
        System.out.println(i);
    }

    public int res = -1;
    public int level;

    public int KthNode(TreeNode proot, int k) {
        //方法1 后序遍历 递归 所拿到的值就是
        if (proot == null) return -1;
        helper(proot, k);
        return res;
        //仿佛2 后序遍历 拿到list get(k-1)
    }

    private void helper(TreeNode head, int k) {
        if (head == null) return;
        helper(head.left, k);
        if (++level == k) res = head.val;
        helper(head.right, k);
    }

}
