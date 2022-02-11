package normal;


import java.util.*;

/**
 * 二叉树的中序遍历  左根右
 */
public class InorderTraversal {

//     Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
     //非递归法遍历
     public  static  List<Integer> inorderTraversal1(TreeNode root) {
         List<Integer> res = new ArrayList<Integer>();
         Deque<TreeNode> stk = new LinkedList<TreeNode>();
         while (root != null || !stk.isEmpty()) {
             while (root != null) {
                 stk.push(root);
                 root = root.left;
             }
             root = stk.pop();
             res.add(root.val);
             root = root.right;
         }
         return res;
     }
    //广度优先遍历是使用队列实现的
    public void BroadFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Queue<TreeNode> myQueue=new LinkedList<>();
        myQueue.add(nodeHead);
        while(!myQueue.isEmpty()) {
            TreeNode node=myQueue.poll();
            System.out.print(node.val+" ");
            if(null!=node.left) {
                myQueue.add(node.left);
            }
            if(null!=node.right) {
                myQueue.add(node.right);
            }

        }
    }

    //深度优先遍历
    public void depthFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Stack<TreeNode> myStack=new Stack<>();
        myStack.add(nodeHead);
        while(!myStack.isEmpty()) {
            TreeNode node=myStack.pop();    //弹出栈顶元素
            System.out.print(node.val+" ");
            if(node.right!=null) {
                myStack.push(node.right);    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
            }
            if(node.left!=null) {
                myStack.push(node.left);
            }
        }

    }




    //递归法中序遍历
    static ArrayList<Integer> list = new ArrayList<>();
    public  static  List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(3);
        List<Integer> list = inorderTraversal(treeNode);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
