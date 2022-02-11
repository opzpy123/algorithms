package easy;


import java.lang.reflect.Array;
import java.util.*;

public class Merge {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {1};
        merge(num1,3,new int[]{2,5,6},3);
        merge(num2,1,new int[]{},0);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last=m+n-1;
        while(n!=0){
            if(m==0||nums1[m-1]<=nums2[n-1]){
                nums1[last--]=nums2[--n];
            }else{
                nums1[last--]=nums1[--m];
            }
        }
    }
}

