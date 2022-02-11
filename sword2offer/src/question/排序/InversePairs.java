package question.排序;

/**
 * 描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 * <p>
 * 数据范围：  对于 50\%50% 的数据, size\leq 10^4size≤10
 * 4
 * <p>
 * 对于 100\%100% 的数据, size\leq 10^5size≤10
 * 5
 * <p>
 * 数组中所有数字的值满足 0 \le val \le 10000000≤val≤1000000
 * <p>
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 */
public class InversePairs {
    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        System.out.println(inversePairs.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
        System.out.println(inversePairs.InversePairs(new int[]{1, 2, 3}));
    }

    public int InversePairs(int[] array) {
        int res = 0;
        if (array == null) return res;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    res++;
                    res %= 1000000007;
                }
            }
        }
        return res;
    }
}
