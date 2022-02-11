package question.树;

import common.TreeNode;

import java.util.Stack;

public class HasSubtree {
    public static void main(String[] args) {
//        TreeNode head1 = new TreeNode(8);
//        head1.left = new TreeNode(8);
//        head1.right = new TreeNode(7);
//        head1.left.left = new TreeNode(9);
//        head1.left.right = new TreeNode(2);
//        head1.left.right.left = new TreeNode(4);
//        head1.left.right.right = new TreeNode(7);
//
//        TreeNode head2 = new TreeNode(8);
//        head2.left = new TreeNode(9);
//        head2.right = new TreeNode(2);
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);
//        head1.left.left = new TreeNode(9);
//        head1.left.right = new TreeNode(2);
//        head1.left.right.left = new TreeNode(4);
//        head1.left.right.right = new TreeNode(7);

        TreeNode head2 = new TreeNode(2);
        head2.left = new TreeNode(3);

        HasSubtree hasSubtree = new HasSubtree();
        System.out.println(hasSubtree.hasSubtree(head1, head2));

    }

    boolean res = false;

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        //遍历root1
        if (root1 == null || root2 == null) return false;
        if (res) return true;
        if (root1.val == root2.val) {
            //root 1与root2 一起遍历
            Stack<TreeNode> treeNodes1 = new Stack<>();
            Stack<TreeNode> treeNodes2 = new Stack<>();
            treeNodes1.add(root1);
            treeNodes2.add(root2);
            while (!treeNodes2.isEmpty()) {
                if (treeNodes1.isEmpty()) continue;
                TreeNode pop1 = treeNodes1.pop();
                TreeNode pop2 = treeNodes2.pop();
                if (pop1 == null || pop1.val != pop2.val) continue;
                if (pop2.left != null) {
                    treeNodes1.add(pop1.left);
                    treeNodes2.add(pop2.left);
                }
                if (pop2.right != null) {
                    treeNodes1.add(pop1.right);
                    treeNodes2.add(pop2.right);
                }
                if (pop2.left == null && pop2.right == null) res = true;
            }
        }
        res = res || hasSubtree(root1.left, root2);
        res = res || hasSubtree(root1.right, root2);
        return res;
    }
}
