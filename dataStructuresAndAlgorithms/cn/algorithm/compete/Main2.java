package compete;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        //获取元数据数据 与最小值及其所在位置
        int[] arr = new int[split.length];
        int n = split.length;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        int[] vals = new int[n];
        int l = minIndex, r = minIndex;
        vals[minIndex]=1;
        while (l > 0 || r < n) {
            if (l > 0) {
                //走左边
                if(l-1>0&&arr[l-1]>arr[l]){
                    vals[l-1]=vals[l]+1;
                }else if(l-1>0&&arr[l-1]==arr[l]){
                    vals[l-1]=1;
                }
                l--;
            }
            if (r < n) {
                //走右边
                if(r+1<n&&arr[r+1]>arr[r]){
                    vals[r+1]=vals[r]+1;
                }else if(r+1<n&&arr[r+1]==arr[r]){
                    vals[r+1]=1;
                }
                r++;
            }
        }

        int res=0;
        for (int i = 0; i < n; i++) {
            res+=vals[i];
        }
        System.out.println(res);
    }
}
