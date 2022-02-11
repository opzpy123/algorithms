package normal;

import java.util.Stack;

public class IsValidSerialization {
	public boolean isValidSerialization(String preorder) {
		String[] split = preorder.split(",");
		int[] stack = new int[split.length];
		int idx = 0;

		for (String s : split) {
			while (idx > 1 && s.equals("#") && stack[idx - 1] == 0) {
				if (stack[idx - 2] == 0) return false;
				idx -= 2;
			}
			stack[idx++] = s.equals("#") ? 0 : 1;
		}

		return idx == 1 && stack[idx - 1] == 0;
	}
}
