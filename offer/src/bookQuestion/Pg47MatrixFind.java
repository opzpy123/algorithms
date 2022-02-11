package bookQuestion;

import java.util.ArrayList;

/**
 * 第47页二维数组的二分查找
 */
public class Pg47MatrixFind {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Pg47MatrixFind pg47MatrixFind = new Pg47MatrixFind();
        pg47MatrixFind.isContains(arr, 11);
    }

    private static boolean flag = false;

    private void isContains(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        int row = 0;
        int col = cols-1;
        while (row<rows&&col>=0){
            if(arr[row][col]==target){
                flag=true;
                break;
            }else if (arr[row][col]>target){
                col--;
            }else {
                row++;
            }
        }
        System.out.println(flag);
    }
}
