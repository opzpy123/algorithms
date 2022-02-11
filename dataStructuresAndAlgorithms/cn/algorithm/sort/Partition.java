package sort;

import java.util.Arrays;

public class Partition {
    public static void main(String[] args) {
        int[] arr = new int[]{99,124,4,67,3, 6, 5, 4, 3, 2, 1, 8, 9, 11, 12, 123, 421, 55};
        System.out.println(partition(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr,int low , int high){
        int pivot =arr[low];
        while (low<high){
            while (low<high&&pivot<=arr[high])high--;
            arr[low]=arr[high];
            while (low<high&&pivot>=arr[low])low++;
            arr[high]=pivot;
        }
        arr[low]=pivot;
        return pivot;
    }
}
