package hard;

import java.util.Arrays;

public class MaxEnvelopes {
    public static void main(String[] args) {

    }
    public int maxEnvelopes(int[][] es) {
        int n = es.length;
        int[] f = new int[n];
        //对原数组进行排序
        Arrays.sort(es,(e1,e2)->{
            if(e1[0]==e2[0]){
                return e2[1]-e1[1];
            }
            return e1[0]-e2[0];
        });

        int res = 0;
        for(int i=0;i<n ;i++){
            f[i] = 1;
            for(int j=0;j<i;j++){
                if(es[j][1]<es[i][1]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            res = Math.max(res,f[i]);
        }
        return  res;
    }
}
