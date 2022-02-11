package graph;

/**
 * 深度优先搜索，优先搜索结点的子节点而不是兄弟结点
 */
public class DepthFirstSearch {
    //索引代表结点，值代表当前节点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s定点相通
    private int count;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
    public DepthFirstSearch(Graph G,int s) {
        //初始化marked数组
        this.marked=new boolean[G.v()];
        //初始化与顶点s相通的顶点的数量
        this.count=0;

        dfs(G,s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相通的顶点
    private void dfs(Graph G,int v){
        //把v顶点标识为以搜索
        marked[v]=true;

        for (Integer w : G.adj(v)) {
            //判断当前w顶点有没有被搜索过，如果没有被搜索过，则递归调用dfs方法进行深度搜索
            if(!marked[w]){
                dfs(G,w);
            }
        }
        //相通顶点数量加1
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
