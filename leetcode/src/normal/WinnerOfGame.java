package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class WinnerOfGame {
    public static void main(String[] args) {
        String str = "  {\n" +
                "      fieldName: 'partAssemblyExt.column0',\n"+
                "   },";
        for (int i = 1; i <=40 ; i++) {
            str=str.replace("column"+(i-1),"column"+i);
            str=str.replace("属性"+(i-1),"属性"+i);
            System.out.println(str);
        }
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
