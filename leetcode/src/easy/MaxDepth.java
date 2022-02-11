package easy;

import java.util.Stack;

public class MaxDepth {


//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     //
     public int maxDepth2(TreeNode root) {
         if (root == null) {
             return 0;
         } else {
             int leftHeight = maxDepth(root.left);
             int rightHeight = maxDepth(root.right);
             return Math.max(leftHeight, rightHeight) + 1;
         }
     }

     //dfs 辅助栈
     public int maxDepth1(TreeNode root) {
         if (root == null)
             return 0;
         //stack记录的是节点，而level中的元素和stack中的元素
         //是同时入栈同时出栈，并且level记录的是节点在第几层
         Stack<TreeNode> stack = new Stack<>();
         Stack<Integer> level = new Stack<>();
         stack.push(root);
         level.push(1);
         int max = 0;
         while (!stack.isEmpty()) {
             //stack中的元素和level中的元素同时出栈
             TreeNode node = stack.pop();
             int temp = level.pop();
             max = Math.max(temp, max);
             if (node.left != null) {
                 //同时入栈
                 stack.push(node.left);
                 level.push(temp + 1);
             }
             if (node.right != null) {
                 //同时入栈
                 stack.push(node.right);
                 level.push(temp + 1);
             }
         }
         return max;
     }



    int maxDepth=0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return maxDepth;
    }

    private void dfs(TreeNode root) {
         if(root==null){
             return;
         }
         Stack<TreeNode> stack = new Stack<>();
         stack.add(root);
         while (!stack.isEmpty()){
             TreeNode node = stack.pop();
             System.out.println(node.val);
             if(node.right!=null){
                 stack.push(node.right);
             }
             if(node.left!=null){
                 stack.push(node.left);
             }
         }
    }


}
