package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanFormArray {
    public static void main(String[] args) {
        CanFormArray canFormArray = new CanFormArray();
        System.out.println(canFormArray.canFormArray(new int[]{1, 2, 3, 4}, new int[][]{{1}, {2, 3}, {4}}));
        System.out.println(canFormArray.canFormArray(new int[]{15, 88}, new int[][]{{15}, {88}}));
        System.out.println(canFormArray.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        System.out.println(canFormArray.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        ArrayList<Integer> todoDelete = new ArrayList<>();
        for (int[] piece : pieces) {
            int l = 0, r = l + piece.length;
            while (r <= arr.length) {
                List<Integer> subList = arrList.subList(l++, r++);
                if (isEqualList(subList, piece)) {
                    todoDelete.addAll(subList);
                    break;
                }
            }
        }
        arrList.removeAll(todoDelete);
        return arrList.isEmpty();
    }

    private Boolean isEqualList(List<Integer> a, int[] b) {
        if (a.size() != b.length) return false;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b[i])) return false;
        }
        return true;
    }
}
