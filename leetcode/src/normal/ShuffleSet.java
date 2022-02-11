package normal;

import java.util.Arrays;
import java.util.Random;

public class ShuffleSet {
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ab";
        char[] arrS = s.toCharArray();
        char[] arrGoal = goal.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrGoal);
        System.out.println(new String(arrS).equals(new String(arrGoal)));
    }
    int[] reset;
    int[] arr;
    public ShuffleSet(int[] nums) {
        arr=Arrays.copyOf(nums,nums.length);
        reset=Arrays.copyOf(nums,nums.length);
    }

    public int[] reset() {
       return reset;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randInt = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randInt];
            arr[randInt] =temp;
        }
        return arr;
    }
}
