package test;

import java.util.Arrays;
import java.util.Locale;

public class AsciiTest {
    public static void main(String[] args) {
        int[] arr = new int[]{50, 999, 1, 2, 3, 4, 66, 0, 2, 89, 100, 23};
        int partition = Partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //比 pivotKey小的都会在左边 比pivotKey大的都会在右边
    private static int Partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && key <= arr[high]) high--;
            arr[low] = arr[high];

            while (low < high && key >= arr[low]) low++;
            arr[high] = key;
        }
        arr[low] = key;
        return low;
    }
}
