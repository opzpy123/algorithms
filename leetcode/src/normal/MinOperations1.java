package normal;

import java.util.Arrays;

public class MinOperations1 {
	public static void main(String[] args) {
		MinOperations1 minOperations1 = new MinOperations1();
		System.out.println(Arrays.toString(minOperations1.minOperations("110")));
		System.out.println(Arrays.toString(minOperations1.minOperations("001011")));
	}

	public int[] minOperations(String boxes) {
		int n = boxes.length();
		int[] ints = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int t = Integer.parseInt(boxes.charAt(j) + "");
				ints[i] += Math.abs(t * (j - i));
			}
		}
		return ints;
	}
}
