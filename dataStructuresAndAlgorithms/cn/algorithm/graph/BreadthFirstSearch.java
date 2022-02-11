package graph;

import linear.Queue;

/**
 * 广度优先搜索（辅助队列）
 */
public class BreadthFirstSearch {
    //索引代表结点，值代表当前节点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s定点相通
    private int count;
    //用来存储搜索邻接表的点
    private Queue<Integer> waitSearch;

    //构造广度优先搜索对象，使用广度优先搜索找出G图中s顶点的所有相邻顶点
    public BreadthFirstSearch(Graph G,int s) {
        this.marked=new boolean[G.v()];
        this.count=0;
        this.waitSearch=new Queue<Integer>();
        bfs(G,s);
    }

    //使用广度优先搜索找出G图中v顶点的所有相邻的顶点
    private void bfs(Graph G,int v){
        //把当前顶点v标识为以搜索
        marked[v]=true;
        //让顶点v进入队列，待搜索
        waitSearch.enqueue(v);
        //通过循环，如果队列不为空则从队列中弹出一个待搜索的的顶点进行搜索
        while (!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            //遍历wait顶点的邻接表
            Queue<Integer> adj = G.adj(wait);
            for (Integer w : adj) {
                if(!marked[w]){
                    bfs(G,w);
                }
            }
        }
        //相通顶点+1
        count++;

    }

    //判断W顶点与S顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }
    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }
}
