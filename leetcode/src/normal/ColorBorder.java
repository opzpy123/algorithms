package normal;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class ColorBorder {
    public static void main(String[] args) {
        ColorBorder colorBorder = new ColorBorder();
        int[][] ints = colorBorder.colorBorder(new int[][]{{1, 1}, {1, 2}}, 0, 0, 3);
        int[][] ints1 = colorBorder.colorBorder(new int[][]{{1, 2, 2}, {2, 3, 2}}, 0, 1, 3);
        int[][] ints2 = colorBorder.colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2);
        print(ints);
        print(ints1);
        print(ints2);


        int[][] ints3 = colorBorder.colorBorder(new int[][]{
                {1, 2, 1, 2, 1, 2},
                {2, 2, 2, 2, 1, 2},
                {1, 2, 2, 2, 1, 2}}, 1, 3, 1);

        //[[1,1,1,1,1,2],
        // [1,2,1,1,1,2],
        // [1,1,1,1,1,2]]
        print(ints3);
    }


    private Stack<Inner> innerStack;
    private HashSet<Inner> trace;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        innerStack = new Stack<>();
        trace = new HashSet<>();
        int targetColor = grid[row][col];
        int maxM = grid.length;
        int maxN = grid[0].length;
        //对这个点 上下左右递归 染色 如果遇到非targetColor颜色的 则终止当前递归

        Inner inner = new Inner(row, col);
        if (check(inner, maxM, maxN, col, row))
            grid[row][col] = color;

        innerStack.add(inner);
        trace.add(inner);
        while (!innerStack.empty()) {
            Inner pop = innerStack.pop();
            //上
            Inner up = new Inner(pop.row - 1, pop.col);
            handler(grid, up, maxM, maxN, targetColor, color, col, row);
            //下
            Inner down = new Inner(pop.row + 1, pop.col);
            handler(grid, down, maxM, maxN, targetColor, color, col, row);
            //左
            Inner left = new Inner(pop.row, pop.col - 1);
            handler(grid, left, maxM, maxN, targetColor, color, col, row);
            //右
            Inner right = new Inner(pop.row, pop.col + 1);
            handler(grid, right, maxM, maxN, targetColor, color, col, row);
        }

        return grid;
    }

    private void handler(int[][] grid, Inner inner, int maxM, int maxN, int targetColor, int color, int iniCol, int iniRow) {
        if (check(inner, maxM, maxN, iniCol, iniRow) && grid[inner.row][inner.col] == targetColor && !trace.contains(inner)) {
            if (grid[inner.row][inner.col] != color) {
                grid[inner.row][inner.col] = color;
                innerStack.add(inner);
                trace.add(inner);
            }
        }
    }

    private boolean check(Inner inner, int maxM, int maxN, int iniCol, int iniRow) {
        int col = inner.col;
        int row = inner.row;
        //越界判断
        if (col < 0 || row < 0 || row >= maxM || col >= maxN) return false;
        //边界上 true
        if (col == 0 || row == 0 || col == maxN - 1 || row == maxM - 1) return true;
        //起始点周围一圈
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (col == iniCol + i && row == iniRow + j && i != 0 && j != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Inner {
        int row;
        int col;

        public Inner(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inner inner = (Inner) o;
            return row == inner.row && col == inner.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }


    private static void print(int[][] grid) {
        for (int[] ints : grid) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("]");
        }
        System.out.println("##########################");
    }
}
