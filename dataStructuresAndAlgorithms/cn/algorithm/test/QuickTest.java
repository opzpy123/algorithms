package test;

import sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] a ={1,6,3,8,2,9,5,7,4};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
