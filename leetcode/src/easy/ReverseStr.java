package easy;

public class ReverseStr {
	public static void main(String[] args) {
		ReverseStr reverseStr = new ReverseStr();
		System.out.println(reverseStr.reverseStr("abcdefg", 4));
//		System.out.println(reverseStr.reverseStr("abcd", 2));
//		System.out.println(reverseStr.reverseStr("a", 2));
	}

	public String reverseStr(String s, int k) {
		int n = s.length();
		char[] arr = s.toCharArray();
		for (int i = 0; i < n; i += 2 * k) {
			reverse(arr, i, Math.min(i + k, n) - 1);
		}
		return new String(arr);
	}

	public void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
