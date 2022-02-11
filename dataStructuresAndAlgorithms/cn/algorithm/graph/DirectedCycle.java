package graph;

import linear.Queue;

/**
 * 有向图是否有环
 */
public class DirectedCycle {
    //创建代表顶点，值代表当前顶点是否已经被搜索
    private  boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private  boolean[] onStack;

    //创建一个检测环对象，监测图G中是否有环
    public DirectedCycle(Digraph G){
        //初始化marked数组
        this.marked=new boolean[G.V()];
        //初始化hasCycle
        hasCycle=false;
        //初始化onStack数组
        this.onStack=new boolean[G.V()];

        //找到图中每一个顶点，让每一个顶点作为入口调用一次dfs进行搜索
        for (int i = 0; i < G.V(); i++) {
            //判断如果当前顶点还没有搜索过，则调用dfs进行搜索
            if(!marked[i]) {
                dfs(G, i);
            }
        }
    }

    //基于深度优先搜索，就按测图G中是否有环
    private void dfs(Digraph G,int v){
        //把顶点v设置为已标识
        marked[v]=true;

        //把当前顶点进栈
        onStack[v]=true;

        //进行深度优先搜索
        Queue<Integer> adj = G.adj(v);
        for (Integer w : adj) {
            //判断如果当前顶点w没有被搜索过，则继续递归调用dfs方法，完成深度优先搜哦
            if(!marked[w]){
                dfs(G,w);
            }
            //判断当前结点是否已经在栈中，在栈中有环
            if(onStack[w]){
                hasCycle=true;
                return;
            }
        }
        //把当前顶点出栈
        onStack[v]=false;
    }

    //判断当前有向图G中是否有环
    public boolean hasCycle(){
        return hasCycle;
    }
}
