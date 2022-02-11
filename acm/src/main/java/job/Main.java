package job;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 1; i <= n; i++) {
			num[i-1]=i;
		}
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			//翻转l-r区间的数组
			while (l<r){
				int temp =num[l];
				num[l]=num[r];
				num[r]=temp;
				l++;
				r--;
			}

		}
		int count=0;
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				if(num[i]>num[j]){
					count++;
				}
			}
		}
		System.out.println(count);

	}
}
