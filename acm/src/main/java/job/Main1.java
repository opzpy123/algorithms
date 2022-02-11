package job;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int T = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
		//0u  1v  2w;
		int[][] path = new int[n-1][3];
		for (int i = 0; i < n - 1; i++) {
			String line = sc.nextLine();
			String[] s = line.split(" ");
			path[i][0]=Integer.parseInt(s[0]);
			path[i][1]=Integer.parseInt(s[1]);
			path[i][2]=Integer.parseInt(s[2]);
		}
		//已有a path T 求答案
		int yami=0;
		int step=0;
		//依次找路途最短的且美味值最高的
		while (step<=T) {
				for (int i = 0; i < n - 1; i++) {
					if (path[i][2] == 0) {
						yami += a[path[i][0]];
						yami += a[path[i][1]];
					} else {
						step = path[i][2];
						if (step < T) {
							T-=step;
							yami += a[path[i][0]];
							yami += a[path[i][1]];
						}
					}
				}
		}
		System.out.println(yami);
	}
}
