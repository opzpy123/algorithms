package uf;

/**
 * 并查集优化
 */
public class UF_Tree {
    //记录节点元素和该元素所在分组的表示
    private int[] eleAnaGroup;
    //记录并查集中数据的分组个数
    private int count;
    //初始化并查集

    public UF_Tree(int N) {
        //初始化分组的数量
        this.count = N;
        //初始化eleAndGroup数组
        this.eleAnaGroup = new int[N];
        //初始化eleAndGroup中的元素及所在的组的标识符
        //让eleAndGroup数组的索引作为并查集的每个节点的元素，
        // 并且让每个索引处的值（该元素所在组的标识符）就是索引
        for (int i = 0; i < eleAnaGroup.length; i++) {
            eleAnaGroup[i] = i;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count() {
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //元素p所在分组的标识符
    public int find(int p) {
        while (true){
            if(eleAnaGroup[p]==p){
                return p;
            }
            p=eleAnaGroup[p];
        }
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //找到p元素和q元素所在组对应的树的根节点
        int pRoot = find(p);
        int qRoot = find(q);

        //如果p和q已经在同一分组，则不需要合并了
        if(pRoot==qRoot){
            return;
        }

        //让p所在的树的根节点的父节点为q所在树的根节点即可
        eleAnaGroup[pRoot] = qRoot;
        //组的数量-1
        this.count--;

    }
}
