package normal;

import java.util.Arrays;

public class NextGreaterElements {
    public static void main(String[] args) {
        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(new int[]{1, 2, 3,4,3})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res= new int[n];
        int[] help = new int[2*n];
        //当前数组遍历两次 生成help
        for (int i = 0; i < n; i++) {
            help[i]=nums[i];
            help[i+n]=nums[i];
        }
        for (int i=0;i<n;i++){
            int flag = hasBiggerItem(i, help,n);
            res[i]=flag;
        }
        return  res;
    }
    private int hasBiggerItem(int index,int[] help,int n){
        int res=help[index];
        for (int i = index; i < n+index; i++) {
            if(help[i]>res){
                return help[i];
            }
        }
        return -1;
    }
}
