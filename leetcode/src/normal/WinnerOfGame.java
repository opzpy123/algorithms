package normal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class WinnerOfGame {
    public static void main(String[] args) {
        AtomicReference<String> str = new AtomicReference<>("asdas");
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        integers.forEach(a->{
            str.set(a+str.get());
        });
        System.out.println(str);


//        WinnerOfGame winnerOfGame = new WinnerOfGame();
//        System.out.println(winnerOfGame.winnerOfGame("AAABABB"));
//        System.out.println(winnerOfGame.winnerOfGame("AA"));
//        System.out.println(winnerOfGame.winnerOfGame("ABBBBBBBAAA"));
//        System.out.println(winnerOfGame.winnerOfGame("ABBBBBBBAAA"));
    }
    public boolean winnerOfGame(String a) {
        //遍历一遍判断有多少个满足的可删除的点就行了
        int sum = 0;
        char[] colors = a.toCharArray();
        for(int i = 1;i < colors.length-1;i++){
            if(colors[i-1] == 'A'&&colors[i] == 'A'&&colors[i+1] == 'A')
                sum++;
            if(colors[i-1] == 'B'&&colors[i] == 'B'&&colors[i+1] == 'B')
                sum--;
        }
        return sum > 0;
    }
}
