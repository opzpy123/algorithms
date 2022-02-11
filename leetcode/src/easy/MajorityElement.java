package easy;

import java.util.*;

public class MajorityElement {

    //分治算法 复杂度O(log n)
    public int majorityElement(int[] nums) {
        return rec(nums,0,nums.length-1);
    }

    private int rec(int[] nums, int lo, int hi) {
        //基本情况：当数组中中只有一个元素时返回它本身
        if(lo==hi){
            return nums[lo];
        }
        //分而治之
        int mid = (hi-lo)/2+lo;

        int left = rec(nums, lo, mid);
        int right = rec(nums, mid + 1, hi);
        //如果两半在多数元素上达成共识，则将其返回。
        if(left==right){
            return left;
        }

        //否则，计算每个元素并返回“赢家”。
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount>rightCount ? left: right;


    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count =0;
        for(int i=lo;i<=hi;i++){
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }


    //暴力算法 复杂度O(n)
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();//key:对应下标 value 出现次数
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            if(map.get(nums[i])>nums.length/2){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }


}
