package question.搜索算法;

import java.util.ArrayList;
import java.util.Arrays;

public class MinNumberInRotateArray {
    public static void main(String[] args) {

    }

    public int minNumberInRotateArray(int [] array) {
//        if(array==null||array.length==0)return -1;
        for (int i = 0; i < array.length-1; i++) {
            if(i+1<array.length&&array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }
}
