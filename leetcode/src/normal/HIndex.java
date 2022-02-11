package normal;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		HIndex hIndex = new HIndex();
		System.out.println(hIndex.hIndex(new int[]{3, 0, 6, 1, 5}));
		System.out.println(hIndex.hIndex(new int[]{11, 15}));
	}
	public int hIndex(int[] citations) {
		int h = 0, i = citations.length - 1;
		while (i >= 0 && citations[i] > h) {
			h++;
			i--;
		}
		return h;
	}


}
