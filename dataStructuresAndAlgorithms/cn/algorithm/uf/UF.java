package uf;

/**
 * 并查集
 */
public class UF {
    //记录节点元素和该元素所在分组的表示
    private int[] eleAnaGroup;
    //记录并查集中数据的分组个数
    private int count;
    //初始化并查集

    public UF(int N) {
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

    //元素p所在分组的标识符
    public int find(int p) {
        return eleAnaGroup[p];
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //判断q和p已经在同一分组，如果在结束方法
        if (connected(p, q)) {
            return;
        }
        //找到P所在分组的标识符
        int pGroup = find(p);
        //找到q所在分组的标识符
        int qGroup = find(q);

        //合并组，让p所在组的所有怨怒是的标识符变为q所有分组的标识符
        for (int i = 0; i < eleAnaGroup.length; i++) {
            if (eleAnaGroup[i] == pGroup) {
                eleAnaGroup[i] = qGroup;
            }
        }
        this.count--;
    }
}
