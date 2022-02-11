package twopart;

/**
 * 二分搜索细节是魔鬼
 */
public class TwoPart {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 3};
        TwoPart twoPart = new TwoPart();
        System.out.println(twoPart.binarySearch(arr, 2));
        System.out.println(twoPart.left_bound(arr, 2));
    }

    //二分搜索 找到第一个匹配的
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    //寻找最左边匹配的
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;//注意  以后都用这种写法

        while (left < right) {//注意   以后都用这种写法
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
}
