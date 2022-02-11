package graph;

import linear.Stack;

/**
 * 拓扑排序：顶点排序
 */
public class DepthFirstOrder {
    //索引代表顶点，值代表当前顶点是否已经被搜索
    private boolean[] marked;

    //使用栈，存储顶点序列
    private Stack<Integer> reversePost;

    //创建一个检测环对象，监测图G中是否有环
    public  DepthFirstOrder(Digraph G){
        //初始化marked数组
        this.marked = new boolean[G.V()];
        //初始化reversePost栈
        this.reversePost= new Stack<Integer>();
        //遍历图中的每一个顶点，让每个顶点作为入口，完成一次深度优先搜索
        for(int v=0 ;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }
    //基于深度优先搜索，把顶点排序放入栈中
    private void dfs(Digraph G,int v){
        //标记当前v已经被搜搜
        marked[v]=true;

        //通过循环递归深度搜索顶点v
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
        //让顶点v进入栈中
        reversePost.push(v);
    }

    //获取顶点线性序列
    public Stack<Integer> reversePost(){
        return reversePost;
    }


}
