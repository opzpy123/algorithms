package question.其他;

import java.util.Arrays;

public class ReOrderArrayTwo {
    public static void main(String[] args) {
        ReOrderArrayTwo reOrderArrayTwo = new ReOrderArrayTwo();
        System.out.println(Arrays.toString(reOrderArrayTwo.reOrderArrayTwo(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(reOrderArrayTwo.reOrderArrayTwo(new int[]{1, 3, 5, 6, 7})));
    }

    public int[] reOrderArrayTwo(int[] array) {
        // write code here
        if(array==null) return new int[0];
        int l = 0, r = array.length - 1;
        while (l < r) {
            while (l < r && array[l] % 2 != 0) l++;
            while (l < r && array[r] % 2 == 0) r--;
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
        return array;
    }
}
