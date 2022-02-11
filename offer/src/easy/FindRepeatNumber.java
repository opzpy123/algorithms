package easy;

public class FindRepeatNumber {
	public static void main(String[] args) {
		System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
	}
	public static int findRepeatNumber(int[] nums) {
		int[] table = new int[100001];
		for (int i = 0; i < nums.length; i++) {
			table[nums[i]]++;
		}
		for (int i = 0; i < table.length; i++) {
			if(table[i]>1){
				return i;
			}
		}
		return 0;
	}
}
