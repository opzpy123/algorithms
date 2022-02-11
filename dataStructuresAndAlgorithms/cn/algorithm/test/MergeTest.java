package test;

import sort.Merge;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] a = {3,5,1,6,777,6,6,6,8,2,9};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
