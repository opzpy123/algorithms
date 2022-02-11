package test;

import sort.Insertion;
import sort.Selection;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr ={4,6,8,7,9,2,10,1};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 网上提供的算法
     * @param A
     */
    public void InsertSortAscending(int[] A){
        for(int j = 1;j < A.length;j++){
            int key = A[j];
            //将A[j]插入排序序列A[1..j-1]
            int i = j - 1;
            while(i >= 0 && A[i] > key){
                A[j+1] = A[i];
                i = i - 1;
            }
            A[i+1] = key;
        }
    }
}
