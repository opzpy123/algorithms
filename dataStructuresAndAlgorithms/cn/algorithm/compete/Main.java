package compete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int n = split.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }
        int M = sc.nextInt();
        int res=0;
        for (int i = 0; i < n; i++) {
            if(i+1<n) {
                for (int j = i + 1; j < n; j++) {
                    if(arr[i]+arr[j]<=M)res++;
                }
            }
        }
        System.out.println(res);
    }
}
