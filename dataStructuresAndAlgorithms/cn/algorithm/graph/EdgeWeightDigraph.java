package graph;

import linear.Queue;

/**
 * 加权有向图
 */
public class EdgeWeightDigraph {
    //顶点总数
    private final int V;
    //边的总数
    private int E;
    //邻接表
    private Queue<DirectedEdge>[] adj;

    //创建一个含有v个顶点的空加权有向图
    public EdgeWeightDigraph(int v){
        this.V=v;
        this.E=0;
        this.adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<DirectedEdge>();
        }
    }
    //获取图中顶点的数量
    public int V(){
        return V;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
    //向加权有向图中添加一条边e
    public void addEdge(DirectedEdge e){
        //边e是有方向的 所以只需要让e出现在起点的邻接表中
        int v = e.from();
        adj[v].enqueue(e);
        E++;
    }
    //获取由顶点v指出的所有的边
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }
    //获取加权有向图的所有边
    public Queue<DirectedEdge> edges(){
        Queue<DirectedEdge> allEdges = new Queue<>();
        for (int i = 0; i < V; i++) {
            for (DirectedEdge e : adj[i]) {
                allEdges.enqueue(e);
            }
        }
        return allEdges;
    }
}
