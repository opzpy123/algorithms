package competeTest.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] num = new int[]{2,3,1,4,1,25,15};
		sort(num);
		System.out.println(Arrays.toString(num));
	}
	private static void sort(int[] num){
		sort(num,0,num.length-1);

	}

	private static void sort(int[] num, int low, int high) {
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
		sort(num,low,j-1);
		//让右子组有序
		sort(num,j+1,high);
	}




}
