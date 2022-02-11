package easy;

import java.util.Arrays;

public class CanMakeArithmeticProgression {
	public boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		int deff = arr[1]-arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]-arr[i-1]!=deff){
				return false;
			}
		}
		return true;
	}
}
