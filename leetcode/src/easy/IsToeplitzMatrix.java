package easy;

import java.util.Arrays;
import java.util.Stack;

public class IsToeplitzMatrix {
    public static void main(String[] args) {
        IsToeplitzMatrix isToeplitzMatrix = new IsToeplitzMatrix();
        System.out.println(isToeplitzMatrix.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(isToeplitzMatrix.isToeplitzMatrix(new int[][]{{}}));
        System.out.println(isToeplitzMatrix.isToeplitzMatrix(new int[][]{{1, 2},{2, 2}}));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length<=1){
            return true;
        }
        int x=matrix[0].length;
        int y =matrix.length;
        int[] Diagonal=new int[matrix[0].length+matrix.length-1];
        boolean result=true;
        //计算竖着的
        for (int i = y-2; i >= 1; i--) {
            int inc=1;
            while (i+inc<y&&inc<x){
                if(matrix[i+inc][inc]!=matrix[i][0]){
                    return false;
                }
                inc++;
            }
        }
        //计算横着的
        for (int i=0;i<x-1;i++){
            int inc=1;
            while (i+inc<x&&inc<y){
                if(matrix[inc][i+inc]!=matrix[0][i]){
                    return false;
                }
                inc++;
            }
        }
        return result;
    }
}
