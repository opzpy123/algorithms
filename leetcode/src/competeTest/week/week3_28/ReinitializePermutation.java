package competeTest.week.week3_28;

import java.util.Arrays;

public class ReinitializePermutation {
	public static void main(String[] args) {
		ReinitializePermutation reinitializePermutation = new ReinitializePermutation();
		System.out.println(reinitializePermutation.reinitializePermutation(2));
		System.out.println(reinitializePermutation.reinitializePermutation(4));
		System.out.println(reinitializePermutation.reinitializePermutation(6));
		System.out.println(reinitializePermutation.reinitializePermutation(8));
		System.out.println(reinitializePermutation.reinitializePermutation(10));
		System.out.println(reinitializePermutation.reinitializePermutation(18));
	}

	public int reinitializePermutation(int n) {
		int res = 1;
		int[] t = new int[n];
		int[] perm = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			perm[i] = i;
			t[i] = i;
		}
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] = perm[i / 2];
			}
			if (i % 2 == 1) {
				arr[i] = perm[n / 2 + (i - 1) / 2];
			}
		}
		perm = Arrays.copyOf(arr, n);
		arr = Arrays.copyOf(t, n);

		while (!Arrays.equals(t, perm)) {
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					arr[i] = perm[i / 2];
				}
				if (i % 2 == 1) {
					arr[i] = perm[n / 2 + (i - 1) / 2];
				}
			}
			perm = Arrays.copyOf(arr, n);
			arr = Arrays.copyOf(t, n);
			res++;
		}
//		System.out.println(Arrays.toString(perm));


		return res;
	}
}
