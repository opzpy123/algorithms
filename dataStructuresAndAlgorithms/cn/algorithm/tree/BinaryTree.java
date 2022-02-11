package tree;


import linear.Stack;
import linear.Queue;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 二叉树
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根节点
    public Node root;
    //记录树中结点的个数
    private int N;

    private class Node {
        //存储键
        private Key key;
        //存储值
        private Value value;
        //记录左子节点
        public Node left;
        //记录右子节点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中元素的个数
    public int size() {
        return N;
    }

    //向树种添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树x中添加key-value并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        //如果x子树为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //如果key>x.key,则继续找x结点的右子树
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //如果key<x.key,则继续找x结点的左子树
            x.left = put(x.left, key, value);
        } else {
            //如果key=x.key，则替换x.value=value
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    private Value get(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x树!=null;
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //如果key>x.key,则继续找x结点的右子树
            return get(x.right, key);
        } else if (cmp < 0) {
            //如果key<x.key,则继续找x结点的左子树
            return get(x.left, key);
        } else {
            //如果key=x.key，则返回键为key的结点的值
            return x.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key) {
        delete(root, key);
    }

    //删除指定树x中的key对应的value,并返回删除后的新树
    public Node delete(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x不为null;
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //如果key>x.key,则继续找x结点的右子树
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //如果key<x.key,则继续找x结点的左子树
            x.left = delete(x.left, key);
        } else {
            //如果key=x.key，则完成删除动作

            //元素个数-1
            N--;

            //两种极端情况简化思路
            if(x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            //找到最小结点
            Node minNode = x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            //删除右子树中最小的结点（放到被删除的结点）
            Node n = x.right;
            while (n.left!=null){
                if(n.left.left==null){
                    n.left=null;
                }else {
                    //变换n结点
                    n=n.left;
                }
            }
            //最小节点替换掉被删除的结点
            //让x结点的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x节点的右子树成为minNode的右子树
            minNode.right=x.right;
            //让x节点的父节点指向minNode
            x=minNode;

        }

        return x;
    }

    //递归查找最小的键
    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left==null){
            return x;
        }else {
            return min(x.left);
        }
    }

    //递归查找最大的键
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right==null){
            return x;
        }else {
            return max(x.right);
        }
    }

    //前序遍历(深度优先)
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    //获取指定树x所有键，并放到keys队列中
    private void preErgodic(Node x ,Queue<Key> keys){
        if(x==null){
            return;
        }
        //把x结点的key放到keys中
        //先根遍历(根遍历在递归前)
        keys.enqueue(x.key);
        //递归遍历左子树
        if(x.left!=null){
            preErgodic(x.left,keys);
        }

        //递归遍历右子树
        if(x.right!=null){
            preErgodic(x.right,keys);
        }


    }

    //中序遍历(深度优先)
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    //获取指定树x所有键，并放到keys队列中
    private void midErgodic(Node x ,Queue<Key> keys){
        if(x==null){
            return;
        }
        //递归遍历左子树
        if(x.left!=null) {
            midErgodic(x.left, keys);
        }
        //把x结点的key放到keys中
        //中根
        keys.enqueue(x.key);
        //递归遍历右子树
        if(x.right!=null){
            midErgodic(x.right,keys);
        }
    }

    //后序遍历(深度优先)
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    //获取指定树x所有键，并放到keys队列中
    private void afterErgodic(Node x ,Queue<Key> keys){
        if(x==null){
            return;
        }
        //递归遍历左子树
        if(x.left!=null) {
            afterErgodic(x.left, keys);
        }

        //递归遍历右子树
        if(x.right!=null){
            afterErgodic(x.right,keys);
        }
        //把x结点的key放到keys中
        //后序
        keys.enqueue(x.key);
    }

    //使用层序遍历(广度优先遍历)，获取整个书中所有的键
    public Queue<Key> layerErgodic(){
        //定义两个队列，分别存储树中的键和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认，往队列中放入根节点
        nodes.enqueue(root);

        while (!nodes.isEmpty()){
            //从队列中弹出一个节点，把key放入keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //判断当前结点还有没有左子节点，如果有则放入nodes中
            if(n.left!=null){
                nodes.enqueue(n.left);
            }
            //判断当前结点还有没有右子节点，如果有，则放入nodes中
            if(n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    //获取整个树的最大深度
    public int maxDepth(){
      return maxDepth(root);
    }

    //获取指定树x的最大深度
    public int maxDepth(Node x){
        if(x==null){
            return 0;
        }

        int left = 0,right=0;
        if(x.left!=null){
            left=maxDepth(x.left);
        }
        if(x.right!=null){
            right=maxDepth(x.right);
        }

        return Math.max(left, right)+1;
    }

    //DFS和BFS要输出可以先把元素存储到返回队列中返回
    //广度优先搜索(队列实现)
    public void DFS_easy(Node root){
        if(root==null){
            return;
        }
        java.util.Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.value);//在这里输出元素 或者在外面建立辅助元素队列来返回
            if(null!=node.left){
                queue.add(node.left);
            }
            if(null!=node.right){
                queue.add(node.right);
            }
        }
    }
    //分层输出
    public List<List<Integer>> BFS(Node root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (null == root) {
            return rs;
        }
        java.util.Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> binary = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                binary.add((Integer)node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            rs.add(binary);
        }
        return rs;
    }

    //深度优先搜索(栈实现)
    public void DFS(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.value);//在这里输出元素 或者在外面建立辅助元素队列来返回
            if(null!=node.left){
                stack.push(node.left);
            }
            if(null!=node.right){
                stack.push(node.right);
            }
        }
    }

    //深度优先搜索(递归实现)
    public void dfs_recursion(Node root){
        if(root == null)
            return;
        System.out.println(root.value);
        if(root.left != null)
            dfs_recursion(root.left);
        if(root.right != null)
            dfs_recursion(root.right);
    }
}
