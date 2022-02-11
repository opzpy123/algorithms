package competeTest.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] num = new int[]{2,3,1,4,1,25,15};
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - i - 1; j++) {
				if(num[j]>num[j+1]){
					int t = num[j];
					num[j]=num[j+1];
					num[j+1]=t;
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}
}
