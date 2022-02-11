package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        //初始化棋盘
        List<List<String>> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            ArrayList<String> list = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for (int i1 = 0; i1 < n; i1++) {
                str.append(".");
            }
            list.add(str.toString());
            res.add(list);
        }

        //回溯
        backTrack(res,0,n);

        return res;
    }

    private void backTrack(List<List<String>> res,int index,int n) {
        //termination
        if(index==n){
            //到达底部
            return;
        }

        //process
        //选择第一个节点 下探
        for (;index<n;index++){
            //横移
            for (int i = 0; i < n; i++) {
                if(isValidate(i,index)){
                    backTrack(res,++index,n);
                }
            }
        }
        //isValidate
        //

        //drillDown

        //reverse
    }

    private boolean isValidate(int row, int col) {
        
        return false;
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }


}
