package compete.meituan21_8;
/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美给小团n张数字卡片，问小团在可以任意排列的情况下，能排列出多少种不同的排列，并按字典序写出每种排列方式。
 *
 * 举例：
 *
 * 小美给小团 [1, 2, 3]，则共有6种排列方式，分别是
 *
 * [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]。
 *
 * 小美给小团 [2, 2, 3]，则共有3种排列方式，分别是
 *
 * [2, 2, 3], [2, 3, 2], [3, 2 2]。
 *
 * 我们认为两个排列不同，当且仅当至少存在一个位置pos，两个排列在那个位置的数是不相同的。
 *
 * 我们认为一个排列字典序比另一个字典序小，当且仅当存在一个位置pos，在pos之前两个排列所有的数字相同，而前者在那个位置的数比后者在那个位置的数小，那么前者字典序比后者小。
 *
 *
 *
 * 输入描述
 * 第一行是一个数字n，表示小美一共给了n张数字卡片。
 *
 * 接下来一行n个空格隔开的正整数。
 *
 * 对于60%的数据，数字卡片张数1<= n <= 3。
 *
 * 对于100%的数据，数字卡片张数1<= n <= 6。
 *
 * 数字卡片上的数字x满足1 <= x <= n。
 *
 * 输出描述
 * 第一行输出一个数ans，表示所有不同的排列数。
 *
 * 下面ans行，每行输出一种排列，且排列需要按字典序输出。
 *
 *
 * 样例输入
 * 3
 * 1 1 2
 * 样例输出
 * 3
 * 1 1 2
 * 1 2 1
 * 2 1 1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        ArrayList<int[]> list = new ArrayList<>();
        getFullArray(arr, 0, list);

        //去重
        ArrayList<int[]> ints = new ArrayList<>();
        ints.add(list.get(0));
        for (int[] item : list) {
            boolean f = true;
            for (int[] anInt : ints) {
                if (Arrays.equals(anInt, item)) {
                    f = false;
                    break;
                }
            }
            if(f){
                ints.add(item);
            }
        }
        //排序
        System.out.println(n);
        for (int[] anInt : ints) {
            for (int i = 0; i < anInt.length; i++) {
                System.out.print(anInt[i]+" ");
            }
            System.out.println();
        }
    }

    private static void getFullArray(int[] arr, int start, ArrayList<int[]> list) {
        if (start == arr.length) {
            int[] ints = Arrays.copyOf(arr, arr.length);
            list.add(ints);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            getFullArray(arr, start + 1, list);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int a, int b) {
       int t = arr[a];
       arr[a] = arr[b];
       arr[b] =t;
    }
    private static void swapList(List<int[]> list, int a, int b) {
        int[] ints = list.get(a);
        list.set(a,list.get(b));
        list.set(b,ints);
    }
}
