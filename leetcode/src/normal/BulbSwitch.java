package normal;

import java.util.Arrays;

public class BulbSwitch {
    public static void main(String[] args) {
        BulbSwitch bulbSwitch = new BulbSwitch();
        System.out.println(bulbSwitch.bulbSwitch(3));

    }

    public int bulbSwitch(int n) {
        if (n < 2) return n;
        int[] ints = new int[n + 1];//0亮 1灭
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(j%i==0){
                    ints[j]=1;
                }
            }
        }
        int res=0;
        for (int i = 0; i < ints.length; i++) {
            res+=ints[i];
        }
        return n-res;
    }
}
