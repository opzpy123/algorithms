package question.搜索算法;

/**
 * 描述
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 * <p>
 * 数据范围：0 \le n \le 1000 , 0 \le k \le 1000≤n≤1000,0≤k≤100，数组中每个元素的值满足 0 \le val \le 1000≤val≤100
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(logn)O(logn)
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        System.out.println(getNumberOfK.GetNumberOfK(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 22, 33, 44}, 3));

    }

    private int upper_bound(int[] array, int val) {
        int l = 0, r = array.length - 1, mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (array[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int lower_bound(int[] array, int val) {
        int l = 0, r = array.length - 1, mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (array[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int lowerIndex = lower_bound(array, k);
        int upperIndex = upper_bound(array, k);
        return upperIndex - lowerIndex;
    }

}
