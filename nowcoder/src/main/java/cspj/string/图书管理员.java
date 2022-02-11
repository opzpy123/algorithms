package cspj.string;


import java.util.Scanner;

public class 图书管理员 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] books = new int[n];
		for (int i = 0; i < n; i++) {
			books[i]=sc.nextInt();
		}
		int[] res = new int[q];
		for (int i = 0; i < q; i++) {
			res[i]=-1;
			//需求码长度
			int num = sc.nextInt();
			//用户需要的长度
			int userCode = sc.nextInt();

			//遍历books 获取每一个 从n.length-1-num----n.length-1 判断与当前usercode是否匹配 如果匹配 则保存对应的bookscode
			for (int j = 0; j < books.length; j++) {
				if(new Double(books[j]%Math.pow(10,num)).intValue()==userCode){
					res[i]=books[j];
				}
			}
		}
		for (int x : res) {
			System.out.println(x);
		}
	}
}
