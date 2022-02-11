package easy;

import java.util.LinkedList;
import java.util.List;

public class ReadBinaryWatch {
	public static void main(String[] args) {
		ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
		readBinaryWatch.readBinaryWatch(1);
	}
	public List<String> readBinaryWatch(int turnedOn) {
		List<String> res = new LinkedList<>();
		//直接遍历  0:00 -> 12:00   每个时间有多少1
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				if (count1(i) + count1(j) == turnedOn)
					res.add(i + ":" + (j < 10 ? "0" + j : j));
			}
		}
		System.out.println( res);
		return res;
	}
	int count1(int n) {
		int res = 0;
		while (n != 0) {
			n = n & (n - 1);
			res++;
		}
		return res;
	}
}
