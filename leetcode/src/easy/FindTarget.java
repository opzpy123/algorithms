package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTarget {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right=new TreeNode(3);
        FindTarget findTarget = new FindTarget();
        System.out.println(findTarget.findTarget(treeNode, 6));
    }

    private List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = i+1; i1 < list.size(); i1++) {
                if(list.get(i)+list.get(i1)==k)return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root){
        if(root==null)return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
