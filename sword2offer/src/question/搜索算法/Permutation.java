package question.搜索算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.Permutation("ab"));
        System.out.println(permutation.Permutation("aab"));
        System.out.println(permutation.Permutation("abc"));
        System.out.println(permutation.Permutation(""));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        helper(str.toCharArray(), 0, res);
        return res;
    }

    private void helper(char[] arr, int pos, ArrayList<String> set) {
        if (pos == arr.length) return;
        String s = new String(arr);
        if (!set.contains(s)) set.add(s);
        for (int i = 0; i < arr.length; i++) {
            swap(arr, pos, i);
            helper(arr, pos + 1, set);
            swap(arr, pos, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
