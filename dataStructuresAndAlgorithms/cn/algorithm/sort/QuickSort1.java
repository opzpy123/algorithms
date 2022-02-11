package sort;

import java.util.Arrays;

public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{98, 54, 124, 6436, 128192749, 1, 28197218, 234023, 2539823, 23983582, 48, 493, 0, 25, 2};
        QuickSort1 quickSort1 = new QuickSort1();
        quickSort1.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int partition = partition(arr, l, r);
        sort(arr, l, partition - 1);
        sort(arr, partition + 1, r);
    }

    private int partition(int[] data, int start, int end) {
        swap(data, start, end);
        int temp = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                ++temp;
                swap(data, i, temp);
            }
        }
        ++temp;
        swap(data, temp, end);
        return temp;
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
