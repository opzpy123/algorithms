package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[18];
        for (int i = 0; i < 18; i++) {
            arr[i]=random.nextInt(100);
        }
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i : arr) {
            arrayLists.get(i/10).add(i);
        }
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }
}
