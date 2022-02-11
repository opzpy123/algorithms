package competeTest.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		List<List<Integer>> list= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			list.add(new ArrayList<>(arr[i]));
		}
		for (int i = 0; i < m; i++) {
			int flag = sc.nextInt();
			int b1 = sc.nextInt();
			int b2 = sc.nextInt();
			if(flag==1){
				for (List<Integer> integers : list) {
					for (Integer integer : integers) {
						if(integer==b1){
							integers.add(b2);
						}
						if(integer==b2){
							integers.add(b1);
						}
					}
				}
			}
			if(flag==2){
				for (List<Integer> integers : list) {
					if(integers.contains(b1)||integers.contains(b2)){
						System.out.println("YES");
					}else {
						System.out.println("NO");
					}
				}
			}
		}
	}
}
