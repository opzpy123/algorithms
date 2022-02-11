package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : nums1) {
            integers.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if(integers.contains(i)&&!res.contains(i)){
                res.add(i);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
