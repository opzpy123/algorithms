package easy;

import java.util.*;

public class RemoveDuplicates {
	public static void main(String[] args) {
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		System.out.println(removeDuplicates.removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String S) {
		char[] chars = S.toCharArray();
		Deque<Character> stack = new LinkedList<>();
		for (char aChar : chars) {
			if (!stack.isEmpty() && stack.peek().equals(aChar)) {
				stack.pop();
			} else {
				stack.push(aChar);
			}
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			Character character = stack.removeLast();
			res.append(character);
		}
		return res.toString();
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) return nums.length;
		int idx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[idx] != nums[i]) {
				nums[++idx] = nums[i];
			}
		}
		return ++idx;
	}
}
