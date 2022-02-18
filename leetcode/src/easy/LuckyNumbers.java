package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LuckyNumbers {
    public static void main(String[] args) {
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        System.out.println(luckyNumbers.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));

    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        //记录每一列的最大值
        int[] eachColMax = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int col_max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                col_max=Math.max(col_max,matrix[j][i]);
            }
            eachColMax[i]=col_max;
        }

        //记录每一行的 最小值
        for (int i = 0; i < matrix.length; i++) {
            int row_min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                row_min=Math.min(row_min,matrix[i][j]);
            }
            if(row_min==eachColMax[i]){
                res.add(row_min);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());



    }
}
