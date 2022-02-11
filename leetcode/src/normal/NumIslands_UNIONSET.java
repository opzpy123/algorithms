package normal;

/**
 * 岛屿数量 并查集解决
 */
public class NumIslands_UNIONSET {
    public int numIslands(char[][] grid) {
        int n =grid.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i=0;i<n;i++){
            for(int j =i;j<n;j++){
                if(grid[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }

        return unionFind.count;
    }
    class UnionFind{
        private int count = 0;
        private int[] parent;
        public UnionFind(int n){
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];//每次去到上一层,一直到所属集合头元素标记
            }
            return p;
        }
        public void union(int p , int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP==rootQ)return;
            parent[rootP] = rootQ;
            count--;
        }
    }
}
