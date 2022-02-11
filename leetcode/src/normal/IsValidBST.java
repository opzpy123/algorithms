package normal;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        bfs(root);
        if(list.size()==0){
            return true;
        }else {
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i-1)>=list.get(i))
                    return false;
            }
        }
        return true;
    }

    private void bfs(TreeNode root) {
        if(root==null){
            return;
        }
        bfs(root.left);
        list.add(root.val);
        bfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(3);

        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));

    }
}
