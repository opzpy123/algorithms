package competeTest.week.week4_25;

public class SumBase {
	public static void main(String[] args) {
		System.out.println(new SumBase().sumBase(34, 6));
	}
	public int sumBase(int n, int k) {
		int res = 0;
		while (n > 0) {
			res += n % k;
			n /= k;
		}
		return res;
	}
}
