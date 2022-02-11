package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsWithDup {
	public static void main(String[] args) {
		SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
		System.out.println(subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2}));
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> t = new ArrayList<>(res.get(j));
				t.add(nums[i]);
				if(!res.contains(t))res.add(t);
			}
		}
		return res;
	}


}
