package question.搜索算法;

import java.util.ArrayList;

/**
 * 描述
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * <p>
 * 给定 target = 3，返回 false。
 * <p>
 * 数据范围：矩阵的长宽满足 0 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0 \le val \le 10^90≤val≤10
 * 9
 * <p>
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n+m)O(n+m)
 */
public class Find {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] arr1 = new int[][]{{}};
        Find find = new Find();
        System.out.println(find.Find(16, arr1));
    }

    public boolean Find(int target, int[][] array) {
        if (array==null||array.length==0) return false;
        int len = array[0].length;
        boolean res = false;
        for (int[] ints : array) {
            if(ints.length==0){
                res=false;
                break;
            }
            if (ints[0] <= target && ints[len - 1] >= target) {
                res |= hasTargetContains(target, ints);
            }
        }
        return res;
    }

    private boolean hasTargetContains(int target, int[] arr) {
        if(arr==null||arr.length==0)return false;
        int l = 0, r = arr.length - 1, mid;
        while (l < r) {
            mid = (r + l) >> 1;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) {
                l = mid;
            } else if (arr[mid] < target) {
                r = mid;
            }
        }
        return false;
    }
}
