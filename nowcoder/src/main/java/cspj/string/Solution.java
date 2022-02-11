package cspj.string;

import java.util.*;


public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.exportAllOrders(new int[]{1,2,3});
	}
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 *
	 * @param array int整型一维数组
	 * @return int整型二维数组
	 */
	public int[][] exportAllOrders(int[] array) {
		Arrays.sort(array);
		perm(array, 0);
		return null;
	}

	public void perm(int[] array, int start) {
		if (start == array.length){
			System.out.println(Arrays.toString(array));
		}
		for (int i = start; i < array.length; i++) {
			swap(array, start, i);
			perm(array, start + 1);
			swap(array, start, i);
		}
	}

	private void swap(int[] array, int a, int b) {
		int t = array[a];
		array[a] = array[b];
		array[b] = t;
	}
}