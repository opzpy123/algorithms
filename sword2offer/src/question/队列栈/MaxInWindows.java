package question.队列栈;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxInWindows {
    public static void main(String[] args) {
        MaxInWindows maxInWindows = new MaxInWindows();
        System.out.println(maxInWindows.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
        System.out.println(maxInWindows.maxInWindows(new int[]{9,10,9,-7,-3,8,2,-6}, 5));
    }
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        int maxVal = 0;
        if (num.length < size||size==0) return res;
        int left = 0;
        int right = size + left;
        while (right <= num.length) {
            res.add(maxVal(Arrays.copyOfRange(num,left,right)));
            right++;
            left++;
        }
        return res;
    }

    private int maxVal(int[] arr) {
        int res = arr[0];
        for (int i : arr) {
            res = Math.max(i,res);
        }
        return res;
    }
}
