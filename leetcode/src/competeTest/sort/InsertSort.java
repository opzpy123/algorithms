package competeTest.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] num = new int[]{57,68,59,52};
		sort(num);
		System.out.println(Arrays.toString(num));
	}
	private static void sort(int[] num){
		for (int i = 1; i < num.length; i++) {
			for (int j = i; j >0; j--) {
				if(num[j-1]>num[j]){
					int t=num[j-1];
					num[j-1]=num[j];
					num[j]=t;
				}
			}
		}
	}
}
