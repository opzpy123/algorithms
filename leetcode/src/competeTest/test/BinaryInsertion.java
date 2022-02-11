package competeTest.test;

public class BinaryInsertion {
    private int[] nums;

    public BinaryInsertion(int[] nums) {
        this.nums = nums;
    }

    //binary insertion sort
    public int[] binaryInsertionSort(int target) {
        insertSort();
        int index = binarySearch(target);
        int len = nums.length;
        int[] temp = nums;
        nums = new int[len + 1];
        for (int i = 0; i < index; i++) {
            nums[i] = temp[i];
        }
        nums[index] = target;
        for (int i = index + 1; i <= len; i++) {
            nums[i] = temp[i - 1];
        }
        return nums;
    }
    //get target index
    private int binarySearch(int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    //sort nums
    private void insertSort() {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(nums[j - 1], nums[j])) {
                    exch(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    //isV>W?
    private boolean greater(int v, int w) {
        return v > w;
    }

    //exchange  a[i],a[j]
    private void exch(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
