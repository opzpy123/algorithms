package normal;

import java.util.Arrays;
import java.util.regex.Matcher;


// 9 73 98  =3?
public class MaximumElementAfterDecrementingAndRearranging {
	public static void main(String[] args) {
		MaximumElementAfterDecrementingAndRearranging maximumElementAfterDecrementingAndRearranging = new MaximumElementAfterDecrementingAndRearranging();
		System.out.println(maximumElementAfterDecrementingAndRearranging.maximumElementAfterDecrementingAndRearranging(new int[]{9, 73, 89}));
	}

	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		if (check(arr)) {
			return arr[arr.length - 1];
		} else {
			arr[0]=1;
			for (int i = 1; i < arr.length; i++) {
				if (!(Math.abs(arr[i] - arr[i - 1]) <= 1)) {
					arr[i] = arr[i - 1] + 1;
				}
			}
		}
		return arr[arr.length - 1];
	}

	private boolean check(int[] arr) {
		if (arr[0] != 1) {
			return false;
		}
		for (int i = 1; i < arr.length; i++) {
			if (!(Math.abs(arr[i] - arr[i - 1]) <= 1)) {
				return false;
			}
		}
		return true;
	}

}
