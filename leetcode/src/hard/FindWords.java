package hard;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    private List<String> rs = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        int maxSize = 0;
        for (String s : words) {
            trie.insert(s);
            maxSize = Math.max(maxSize,s.length());
        }
//      board深度优先遍历 每次去匹配两个前缀 匹配不到则提前终止 去匹配下一位 直到isEnd
        int depth=0;
        for (int i = 0; i <board.length; i++) {
            for (int j=0 ;j<board[i].length;j++){
                dfs(depth,board,trie,i,j,maxSize);
            }
        }

        return rs;
    }

    private void dfs(int depth, char[][] board, Trie trie,int i ,int j,int maxSize) {
        //termination
        if(depth==maxSize){
            return;
        }
        //process
        //四向判断
        if(i<board.length){
            //左
            depth++;
//            dfs();
//            board[i-1][j];
        }
        if(i+1<board.length){
            //右
//            board[i+1][j];
        }
        if(j<board[j].length){
            //上
//            board[i][j-1];
        }
        if(j+1<board[j].length){
            //下
//            board[i][j+1];
        }
        //drill down 下一层

        //recersion需不需要返回当前层的状态
    }


}
