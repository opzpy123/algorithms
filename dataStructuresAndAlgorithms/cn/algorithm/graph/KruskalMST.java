package graph;

import linear.Queue;
import priority.MinPriorityQueue;
import uf.UF_Tree_Weighted;

/**
 * kruskal 算法 最小生成树
 * 把边权重 放到最小优先队列中 依次拿出最小的边
 * 判断 当前边是否已在树中，如果是则跳过，否则并查集合并
 */
public class KruskalMST {
    //保存最小生成树的所有边
    private Queue<Edge> mst;
    //索引代表顶点，使用uf.connect(v,w)可以判断v和w是否在同一颗树中
    //uf.union(v,w)可以把v顶点所在的树合并到w顶点所在的树中
    private UF_Tree_Weighted uf;
    //存储图的所有边，使用最小优先队列，对边按照权重进行排序
   private MinPriorityQueue<Edge> pq;

    //根据一副加权无向图，创建最小生成树对象
    public KruskalMST(EdgeWeightedGraph G){
        //初始化mst
        this.mst=new Queue<Edge>();
        //初始化uf
        this.uf=new UF_Tree_Weighted(G.v());
        //初始化pq,最小优先队列底层是堆 从1开始
        this.pq=new MinPriorityQueue<>(G.E()+1);

        //把图中所有的边存储到pq中
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        //遍历pq队列拿到最小权重的边进行处理
        while (!pq.isEmpty()&&mst.size()<G.v()-1){
            //找到权重最小的边
            Edge e = pq.delMin();
            //找到该边的两个顶点
            int v = e.either();
            int w = e.other(v);
            //判断这两个顶点是否已经在同一颗树中，在？不处理：让这两个顶点的两棵树合并
            if(uf.connected(v,w)){
                continue;
            }

            uf.union(v,w);

            //让边1进入到mst队列中，
            mst.enqueue(e);

        }
    }
    //获取最小生成树的所有边
    public Queue<Edge> edges(){
        return mst;
    }
}
