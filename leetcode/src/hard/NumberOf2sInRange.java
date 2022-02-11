package hard;

public class NumberOf2sInRange {
	public static void main(String[] args) {
		NumberOf2sInRange numberOf2sInRange = new NumberOf2sInRange();
		System.out.println(numberOf2sInRange.numberOf2sInRange(559366752));
	}

	public int numberOf2sInRange(int n) {
		int t,res = 0;
		for (int i = 0; i <= n; i++) {
			t = i;
			while (t > 0) {
				if (t % 10 == 2) res++;
				t /= 10;
			}
		}
		return res;
	}
}
