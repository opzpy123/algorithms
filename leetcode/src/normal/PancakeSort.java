package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSort {
    public static void main(String[] args) {
        PancakeSort pancakeSort = new PancakeSort();
        System.out.println(pancakeSort.pancakeSort(new int[]{3, 2, 4, 1, 88, 66, 44, 0, 5, 99}));
//        System.out.println(pancakeSort.pancakeSort(new int[]{1, 2, 3}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        int[] sort_arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sort_arr);

        ArrayList<Integer> res = new ArrayList<>();
        if (Arrays.equals(arr, sort_arr)) return res;

        //form end to begin flip
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != sort_arr[i]) {
                //get index of arr elem that equals sort_arr[i];
                int idx = -1;
                for (int i1 = 0; i1 < arr.length; i1++) {
                    if (arr[i1] == sort_arr[i]) {
                        idx = i1;
                        break;
                    }
                }
                if (idx == -1) break;
                // make this val  index to i

                //1. flip 0-idx
                flip(arr, idx);

                //2. flip 0-i;
                flip(arr, i);

                //3.record the flip index;
                res.add(idx + 1);
                res.add(i + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }

    private void flip(int[] arr, int endInx) {
        if (arr.length <= 1) return;
        int l = 0, r = endInx;
        int t;
        while (l < r) {
            t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
