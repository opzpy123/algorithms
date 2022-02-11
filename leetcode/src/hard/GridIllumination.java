package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class GridIllumination {
    public static void main(String[] args) {
        GridIllumination gridIllumination = new GridIllumination();
        //[1, 0]
        //[1, 1]
        //[1, 1, 0]
        //[1, 0]
        //[1, 0]
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}})));
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 1}})));
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, new int[][]{{0, 0}, {0, 4}}, new int[][]{{0, 4}, {0, 1}, {1, 4}})));
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, new int[][]{{0, 0}, {1, 0}}, new int[][]{{1, 1}, {1, 1}})));
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(6, new int[][]{{1, 1}}, new int[][]{{2, 0}, {1, 0}})));
        System.out.println(Arrays.toString(gridIllumination.gridIllumination(6, new int[][]{{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}}, new int[][]{{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}})));

    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[][] grid = new int[n][n];
        //初始状态 点亮所有灯  灯所在的位置为2 照亮的地方为1
        for (int[] lamp : lamps) {
            light(grid, lamp[0], lamp[1]);
        }

        //核心操作 查询 如果周围存在2 则全部清1为0 并且重新点亮2

        HashSet<Entry<Integer, Integer>> putOutList = new HashSet<>();//熄灭的记录 重新点亮排除
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (grid[queries[i][0]][queries[i][1]] == 1 || grid[queries[i][0]][queries[i][1]] == 2) {
                res[i] = 1;
                if (check(grid, queries[i][0], queries[i][1], putOutList)) {
                    resetGrid(grid, queries[i][0], queries[i][1]);
                    //relight
                    for (int[] lamp : lamps) {
                        Entry<Integer, Integer> lampMapEntry = new Entry<>(lamp[0], lamp[1]);
                        if (!putOutList.contains(lampMapEntry)) {
                            light(grid, lamp[0], lamp[1]);
                        }
                    }
                }
            } else {
                res[i] = 0;
            }
        }
        return res;
    }


    private boolean check(int[][] grid, int row, int col, HashSet<Entry<Integer, Integer>> putOutList) {
        //判断周围有没有2
        boolean flag = false;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (grid[row + i][col + j] == 2) {
                        putOutList.add(new Entry<>(row + i, col + j));
                        flag = true;
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return flag;
    }

    private void light(int[][] grid, int row, int col) {
        int rowMax = grid.length;
        int colMax = grid[0].length;
        //照亮时 避免 修改2
        grid[row][col] = 2;
        //照亮一行
        for (int i = 0; i < colMax; i++) {
            if (grid[row][i] == 0) grid[row][i] = 1;
        }
        //照亮一列
        for (int i = 0; i < rowMax; i++) {
            if (grid[i][col] == 0) grid[i][col] = 1;
        }

        //照亮对角
        int i1 = row, i2 = row;
        int j1 = col, j2 = row;
        while (i1 >= 0 && j1 >= 0) {
            if (grid[i1][j1] == 0) grid[i1][j1] = 1;
            i1--;
            j1--;
        }
        while (i2 < rowMax && j2 < colMax) {
            if (grid[i2][j2] == 0) grid[i2][j2] = 1;
            i2++;
            j2++;
        }

        int i3 = row, i4 = row;
        int j3 = col, j4 = row;
        while (i3 >= 0 && j3 < colMax) {
            if (grid[i3][j3] == 0) grid[i3][j3] = 1;
            i3--;
            j3++;
        }
        while (i4 < rowMax && j4 >= 0) {
            if (grid[i4][j4] == 0) grid[i4][j4] = 1;
            i4++;
            j4--;
        }
    }

    private void resetGrid(int[][] grid, int row, int col) {
        //将周围2置为1
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (grid[row + i][col + j] == 2) {
                        grid[row + i][col + j] = 1;
                    }
                } catch (Exception ignored) {
                }
            }
        }
        //将所有1 置为0
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) grid[i][j] = 0;
            }
        }
    }

    class Entry<K, V> {
        private K row;
        private V col;

        public Entry(K row, V col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(row, entry.row) && Objects.equals(col, entry.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

}
