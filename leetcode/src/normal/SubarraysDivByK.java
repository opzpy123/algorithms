package normal;

/**
 * 前缀和
 */
public class SubarraysDivByK {
	public static void main(String[] args) {
		subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
	}
	public static int subarraysDivByK(int[] A, int K) {
		int N = A.length, sum = 0, ans = 0;
		int[] map = new int[K];
		map[0] = 1;
		for (int i = 1; i <= N; i++) {
			sum = sum + A[i-1];
			int key = (sum % K + K) % K;
			ans += map[key];
			map[key]++;
		}
		return ans;
	}
}
