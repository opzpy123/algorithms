package test;

import linear.Queue;

/**
 * 折纸问题
 */
public class PageFoldingTest {
    public static void main(String[] args) {
        //模拟折纸过程，产生树
        Node<String> tree = createTree(3);
        //遍历树，遍历每个结点
        printTree(tree);
    }

    //通过模拟对折N次纸，产生树

    public static Node<String> createTree(int N){
        //定义根节点
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //1.当前是第一次对折
            if(i==0){
                root=new Node<>("down",null,null);
                continue;
            }
            //2.当前不是第一次对折
            //定义一个辅助队列，通过层序遍历的思想，找到叶子节点
            //叶子结点添加子节点
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);

            //循环遍历队列
            while(!queue.isEmpty()){
                //从队列中弹出一个结点
                Node<String> tmp = queue.dequeue();
                //如果有左子结点则把左子节点放入到队列中
                if(tmp.left!=null){
                    queue.enqueue(tmp.left);
                }
                //如果有右子结点则把右子节点放入到队列中
                if(tmp.right!=null){
                    queue.enqueue(tmp.right);
                }
                //如果同时没有左子结点和右子结点，那么证明该子节点是叶子结点
                //只需要给该结点添加左子节点和右子节点即可
                if(tmp.left==null&&tmp.right==null){
                    tmp.left= new Node<String>("down",null,null);
                    tmp.right= new Node<String>("up",null,null);
                }
            }
        }
       return root;
    }

    //打印树中每个结点到控制台
    public static  void printTree(Node root){
        //需要使用中序遍历完成
        if(root==null){
            return;
        }
        //打印左子树的每个结点
        if(root.left!=null){
            printTree(root.left);
        }
        //打印当前结点
        System.out.print(root.item+" ");
        //打印右子树的每个结点
        if(root.right!=null){
            printTree(root.right);
        }
    }


    //结点类
    private static class Node<T>{
        public T item;

        public Node left;

        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }


}
