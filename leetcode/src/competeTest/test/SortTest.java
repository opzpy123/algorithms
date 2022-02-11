package competeTest.test;

import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		int[] num1 = new int[]{10, 5, 6, 2, 7, 215};
		int[] num2 = new int[]{10, 5, 6, 2, 7, 215};
		bubbleSort(num1);
		quickSort(num2);
		System.out.println(Arrays.toString(num1));
		System.out.println(Arrays.toString(num2));
	}

	//冒泡
	private static void bubbleSort(int[] num) {
		int t=0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - i - 1; j++) {
				if(num[j]>num[j+1]){
					t=num[j];
					num[j]=num[j+1];
					num[j+1] =t;
				}
			}
		}
	}

	//快排
	private static void quickSort(int[] num) {
		quickSort(num,0,num.length-1);
	}

	public static void quickSort(int[] num, int low, int high) {
		//安全性校验
		if(low>high)return;
		//需要对数组中lo索引到hi索引的元素进行分组(左子组，和右子组)
		int i=low,j=high,base=num[low],t;
		while (i<j){
			while (i<j&&num[j]>=base)j--;
			while (i<j&&num[i]<=base)i++;
			if(i<j){
				t=num[i];
				num[i]=num[j];
				num[j]=t;
			}
		}
//		交换num的low和j;
		t=num[low];
		num[low]=num[j];
		num[j]=t;

		//让左子组有序
		quickSort(num,low,j-1);
		//让右子组有序
		quickSort(num,j+1,high);
	}
}
