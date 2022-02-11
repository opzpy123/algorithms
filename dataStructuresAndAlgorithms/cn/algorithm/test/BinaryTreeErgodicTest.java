package test;

import linear.Queue;
import tree.BinaryTree;

/**
 * 二叉树三种遍历方式
 */
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        //创建树对象
        BinaryTree<String, String> tree = new BinaryTree<>();
        //往树中添加元素
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");
        System.out.println("树的深度"+tree.maxDepth());
        //遍历
        Queue<String> keys = tree.midErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+"-"+value);
        }
        System.out.println("------------");
        //层序遍历
        Queue<String> layerErgodic = tree.layerErgodic();
        for (String key : layerErgodic) {
            String value = tree.get(key);
            System.out.println(key+"-"+value);
        }




    }
}
