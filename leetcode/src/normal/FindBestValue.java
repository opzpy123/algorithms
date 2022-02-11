package normal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBestValue {
	public static void main(String[] args) {
		FindBestValue findBestValue = new FindBestValue();
		System.out.println(findBestValue.find1(new int[]{4, 9, 3}, 10));
		System.out.println(findBestValue.find1(new int[]{2, 3, 5}, 10));
		System.out.println(findBestValue.find1(new int[]{60864,25176,27249,21296,20204}, 56803));
	}

	public int findBestValue(int[] arr, int target) {
		int[] arrCopy = Arrays.copyOf(arr,arr.length);
		int[] difference = new int[target+1];
		int curMin = Integer.MAX_VALUE;
		for (int i = 0; i <= target; i++) {
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > i) arr[j] = i;
				sum += arr[j];
			}
			difference[i]=Math.abs(target - sum);
			curMin=Math.min(curMin,difference[i]);
			arr=Arrays.copyOf(arrCopy,arrCopy.length);
		}
		int min =  Integer.MAX_VALUE;
		for (int i =0;i<difference.length;i++){
			min = Math.min(min, difference[i]);
			if(curMin==min){
				return i;
			}
		}
		return 0;
	}

	private int find1(int[] arr, int target){
		int sum=0;
		int n=arr.length;
		Arrays.sort(arr);
		for(int i=0;i<n;i++)
		{
			//计算平均值，如果从第i个开始所有元素为tmp,此时所有元素和为target
			double tmp =(double) (target-sum)/(n-i);

			//题目要求大于tmp的所有值都变成tmp，所以判断第i个元素满不满足，
			//因为排过序了，如果arr[i]>tmp,后面的元素也必定>tmp
			if (arr[i]>tmp)
				return (int)(tmp+0.4); //返回整数，所以五舍六入

			sum+=arr[i];
		}
		return arr[n-1]; //返回最后一个元素
	}
}
