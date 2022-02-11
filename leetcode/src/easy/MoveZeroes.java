package easy;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(i!=j){//换完之后就把这个数据置为0
                    nums[i]=0;
                }
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,9,0,754,0,3,0,124,};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
