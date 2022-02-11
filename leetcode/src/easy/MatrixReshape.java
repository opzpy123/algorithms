package easy;

import java.util.*;

public class MatrixReshape {
    public static void main(String[] args) {
        int [][] arr = new int[][] {{1,2},{3,4},{5,6},{7,8}};
        MatrixReshape matrixReshape = new MatrixReshape();
        int[][] ints = matrixReshape.matrixReshape(arr, 1, 8);
        printMatrix(ints);
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println(list.toString());

        //判断如果无法转换就输出原数组
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        //矩阵变换
        //i=x / n
        //j=x % n
        //​
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

    public static void printMatrix(int[][] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
