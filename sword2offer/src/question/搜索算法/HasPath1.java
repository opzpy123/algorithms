package question.搜索算法;

import java.util.*;

public class HasPath1 {
    public static void main(String[] args) {
        HasPath1 hasPath = new HasPath1();
        boolean res1 = hasPath.hasPath(new char[][]{
                        {'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}},
                "bcced");

        boolean res2 = hasPath.hasPath(new char[][]{
                        {'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}},
                "abcb");
        boolean res3 = hasPath.hasPath(new char[][]{
                        {'a', 'b'}, {'c', 'd'}},
                "abcd");
        boolean res4 = hasPath.hasPath(new char[][]{
                        {'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'},
                        {'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'},
                        {'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
                        {'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
                        {'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}},
                "SLHECCEIDEJFGGFIE");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

    public boolean hasPath (char[][] matrix, String word) {
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];//flag[][]数组，初始化为false，表示未经过的点
        //一次初始化，之后共用 ==>是因为每次试探后，都会复原flag数组
        for(int i = 0; i<= matrix.length-1; ++i){
            for(int j=0; j<=matrix[0].length-1; ++j){//每行每列的全部格子作为起点，开始尝试
                if(dfs(matrix, word, i, j, 0, flag))return true;//如果找到一个，则完成任务+停止尝试，立即返回true
            }
        }
        return false;//全部失败，返回false  //单个尝试的失败不会有任何返回
    }
    public boolean dfs(char[][] matrix, String word, int i, int j, int count, boolean[][] flag){
        if(0<=i && i<= matrix.length-1 && 0<=j && j<=matrix[0].length-1){//统一拦截==>【剪枝】
            if(matrix[i][j] == word.charAt(count) && !flag[i][j]){//匹配++
                ++count;//也可以在后面都用count+1
                if(count == word.length())return true;//完整匹配，则主动停止  //全文仅此一处、是true的源头
                flag[i][j] = true;//【尝试改flag】（与下文还原flag对应）
                //下面递归结构类似4叉树的递归：
                if(dfs(matrix, word, i+1, j, count, flag)
                        || dfs(matrix, word, i-1, j, count, flag)
                        || dfs(matrix, word, i, j+1, count, flag)
                        || dfs(matrix, word, i, j-1, count, flag)
                )return true;//这个return true是带有if的、起到传递true的作用，它不是源头
                flag[i][j] = false;//【还原flag】//注意，平时传值都不需要"还原"（如count），而这里需要。
            }                                   //说明flag[][]数组，传的是指针(而不是提供副本)，递归分支是共用一个的
        }
        return false;
    }


}
