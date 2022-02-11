package test;

import tree.BinaryTree;

/**
 * 二叉查找树测试
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        //测试插入
        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王五");
        System.out.println("先根遍历");
        System.out.println("模拟队列 广度优先搜索");
        tree.BFS(tree.root);
        System.out.println("模拟栈 深度优先搜索");
        tree.DFS(tree.root);
        System.out.println("递归 深度优先搜索");
        tree.dfs_recursion(tree.root);
//        System.out.println("插入完毕后元素的个数:"+tree.size());
//        //测试获取
//        System.out.println("键2对应的元素是:"+tree.get(2));
//        //测试删除
//        tree.delete(3);
//        System.out.println("删除后的元素的个数"+tree.size());
//        System.out.println("删除后键3对应的元素"+tree.get(3));
//
//        System.out.println("最大的键:"+tree.max());
//        System.out.println("最小的键"+tree.min());

    }
}
